package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataProvider implements  IDataProvider {
    ArrayList<Book> listOfBooks = new ArrayList<Book>();
    @Override
    public ArrayList<Book> GetRecords() {
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

        return  listOfBooks;
    }
    public ArrayList<Book> GetRecordsFromTextFile() {
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
        return  listOfBooks;
    }

}
