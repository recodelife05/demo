package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageLibrary implements  IManageLibrary {

    ArrayList<Book> listOfBooks = new ArrayList<Book>();
    IDataProvider _dataProvider;
    Scanner _scanner;
    ManageLibrary(AppConfiguration config,Scanner scanner, IDataProvider provider) throws IOException {
        _dataProvider = provider;
        _scanner = scanner;
        if(config.IsPersist){
           listOfBooks =  _dataProvider.GetRecordsFromTextFile();
        }else {
            listOfBooks = _dataProvider.GetRecords();
        }
    }
    public void AddBook(){
        int  MAXID = listOfBooks.stream().map(r-> r.Id).max(Integer::compare).get();
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
    public   void  RemoveBook(){
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
    public void ChangeStatusOfABook(Availability status){
        System.out.println("Please enter the book id:");
        Scanner sc = new Scanner(System.in);
        int bookId = sc.nextInt();
        UpdateBook(bookId,status);
    }
    private void UpdateBook(Integer BookId,Availability status){
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
    public  void DisplayBooks(Availability status){
        System.out.println("LIST OF " + status.toString() + " BOOKS");
        listOfBooks.stream()
                .filter(c -> c.Status == status)
                .map(r -> "Book Id: " + r.Id.toString() + " Title: " + r.Title + ", Author: "  + r.AuthorName)
                .forEach(p ->  System.out.println(p));
    }
    public void DisplayAllBooks(){
        System.out.println("LIST OF ALL BOOKS");
        listOfBooks.stream()
                .map(r -> "Book Id: " + r.Id.toString() + " Title: " + r.Title + ", Status: " +  r.Status + ", Author: "  + r.AuthorName)
                .forEach(p ->  System.out.println(p));
    }


}
