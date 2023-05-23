package com.example.demo;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.stream.Stream;



public class LibraryManagement {

    private static Scanner _scanner;
    private static AppConfiguration _appConfiguration;

    LibraryManagement(Scanner scanner,AppConfiguration appConfig){
        _scanner = scanner;
        _appConfiguration = appConfig;
    }
    LibraryManagement(AppConfiguration appConfig){
        _appConfiguration = appConfig;
    }
    List<Book> listOfBooks = new ArrayList<Book>();

    public Boolean PersistBooks;
    public void RunProgram() throws IOException {

        if(_appConfiguration.IsPersist){
            System.out.println("System will save in text file: " + _appConfiguration.IsPersist.toString());
            System.out.println("Please make sure books.txt is on the src path.: " + _appConfiguration.IsPersist.toString());
            InitializedBooksTextFile();
        }else {
            System.out.println("System will save in text file: " + _appConfiguration.IsPersist.toString());

            InitializedBooks();
        }


        DisplayMainScreen(_scanner);

    }

    public void InitializedBooks(){
        System.out.println("Initializing Library System");
        System.out.println("Adding Books on the system");
        Book book1 = new Book(1,"Book 1","Author",Availability.BORROWED);
        Book book3 = new Book(2,"Bitcoin is a Hard Money","Saifeen Dean",Availability.RETURNED);
        Book book2 = new Book(3,"Book 2","Author",Availability.RETURNED);
        Book book4 = new Book(4,"Ninja Javascript","John Stark",Availability.BORROWED);
        listOfBooks.add(book2);
        listOfBooks.add(book1);
        listOfBooks.add(book3);
        listOfBooks.add(book4);
    }

    public  void InitializedBooksTextFile() throws IOException {
        String path = "books.txt";
        String line = "";
        String splitBy = ",";
        try
        {
            String currentPath = new java.io.File(".").getCanonicalPath();
            System.out.println("Current dir:" + currentPath);

            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] books = line.split(splitBy);    // use comma as separator
                System.out.println("Books [Id=" + books[0] + ", Title =" + books[1] + ", Author Name =" + books[2] + ", Status=" + books[3]);

                var enumValue = books[3].toUpperCase().equalsIgnoreCase("RETURNED") ? Availability.RETURNED : Availability.BORROWED;
                listOfBooks.add(new Book(Integer.parseInt(books[0]),books[1],books[2],enumValue));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    enum LibraryActions {
        ADDBOOK('A',"Add a Book"),
        BORROWBOOK('B',"Borrow a Book"),
        RETURNEDBOOK('C',"Return a Book"),
        REMOVEDBOOK('D',"Removed a Book"),
        LISTRETURNEDBOOKS('E',"List of Books Returned/Shelf"),
        LISTOFBORROWEDBOOKS('F',"List of Borrowed Books"),
        ADDRANDOMBOOKS('G',"Add Random Books"),
        EXITPROGRAM('X',"Exit Program");
        LibraryActions(Character identifier,String description){
            this.identifier = identifier;
            this.description = description;
        };
        private Character identifier;
        private String description;
        private Character getIdentifier(){
            return  identifier;
        }

        public static Stream<LibraryActions> stream() {
            return Stream.of(LibraryActions.values());
        }

    }

    private void DisplayMainScreen(Scanner sc){
        try{
            MainScreen();
            while(true){
                var input = sc.nextLine();
                //if valid
                var IsValid = false;
                IsValid = TryParseInt(input);

                if(IsValid){
                    RunLibrary(input.toUpperCase().charAt(0));
                }else {
                    InvalidInput();
                }
            }
        }catch (Exception ex){
            System.out.println("Something went wrong.");
            throw ex;
        }
    }
    public void MainScreen(){
        LibraryActions.stream().
                forEach(r -> System.out.println("Press <" + r.getIdentifier() + "> to " + r.description));
    }
    public  void DisplayBooks(Availability status){
        System.out.println("LIST OF " + status.toString() + " BOOKS");
        listOfBooks.stream()
                .filter(c -> c.Status == status)
                .map(r -> "Book Id: " + r.Id.toString() + " Title: " + r.Title + ", Author: "  + r.AuthorName)
                .forEach(p ->  System.out.println(p));
    }
    private void RunLibrary(Character input){
        if(LibraryActions.ADDBOOK.getIdentifier() == input){
            AddBookToSystem();
        } if(LibraryActions.REMOVEDBOOK.getIdentifier() == input) {
             RemoveABook();
        }else if(LibraryActions.BORROWBOOK.getIdentifier() == input){
            ChangeStatusOfABook(Availability.BORROWED);
        }else if(LibraryActions.RETURNEDBOOK.getIdentifier() == input){
            ChangeStatusOfABook(Availability.RETURNED);
        } else if(LibraryActions.LISTOFBORROWEDBOOKS.getIdentifier() == input){
            DisplayBooks(Availability.BORROWED);
        }else if(LibraryActions.LISTRETURNEDBOOKS.getIdentifier() == input){
            DisplayBooks(Availability.RETURNED);
        }else if(LibraryActions.ADDRANDOMBOOKS.getIdentifier() == input) {
            AddRandomBooks();
        }else if(LibraryActions.EXITPROGRAM.getIdentifier() == input) {
            EndScreen();
        }else {
            MainScreen();
        }
    }

    private  void  RemoveABook(){
        System.out.println("Please enter the book id:");
        Scanner scan = new Scanner(System.in);
        var bookId = scan.nextInt();
        if(listOfBooks.stream().filter(r-> r.Id == bookId).count() > 0){
            var bookToRemoved = listOfBooks.stream().filter(r-> r.Id == bookId).findFirst().get();
            listOfBooks.remove(bookToRemoved);
        }else {
            System.out.println("Book is not found");
        }
    }
    private void AddBookToSystem(){
        var MAXID = listOfBooks.stream().map(r-> r.Id).max(Integer::compare).get();
        var previousCount = listOfBooks.stream().count();
        var newID = MAXID + 1;

        System.out.println("Please enter the title:");
        var title = _scanner.nextLine();
        System.out.println("Please enter the author:");
        var author = _scanner.nextLine();

        var newbook = new Book(newID,title,author,Availability.RETURNED);

        listOfBooks.add(newbook);

        if(previousCount < listOfBooks.stream().count()){
            System.out.println("Successfully Added");
            DisplayBooks(Availability.RETURNED);
        }
    }
    private void ChangeStatusOfABook(Availability status){
        System.out.println("Please enter the book id:");
        Scanner sc = new Scanner(System.in);
        int bookId = sc.nextInt();
        UpdateBook(bookId,status);
    }
    public void UpdateBook(Integer BookId,Availability status){
      var taggedAsBorrowed =  listOfBooks.stream().filter(r-> r.Id == BookId);


        var s = taggedAsBorrowed.findFirst();
        var d=  s.get();

        if(taggedAsBorrowed == null){
          System.out.println("Book not found");
      }

      if(d.Status == status){
          System.out.println("Book is already: " + status);
      }else {
          System.out.println("Thank you for borrowing" + d.Title + " Please return on time:");
          d.Status = status;
      }

    }
    //validations
    private static HttpURLConnection con;
    public  void AddRandomBooks(){

        String url = "https://api2.isbndb.com/book/9781934759486";

        try {
            try{
                URL myurl = new URI(url).toURL();
                con = (HttpURLConnection) myurl.openConnection();
                con.setRequestMethod("GET");

            }catch (URISyntaxException e){

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            StringBuilder content;

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();

                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println(content.toString());

        } finally {

            con.disconnect();
        }

    }
    public Boolean TryParseInt(String someText) {
        try {
            int parseInt =  Integer.parseInt(someText);
            return false;
        } catch (NumberFormatException ex) {
            return true;
        }
    }

    //screen display
    private void EndScreen() {
        System.out.println("Thank you for using our Library System.");
    }
    private void InvalidInput(){
        System.out.println("Please enter correct choice.");
    }
}

