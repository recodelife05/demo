package com.example.demo;

public class Book {

    public Book(Integer id,String title,String authorName,Availability status){
        Id = id;
        Title = title;
        AuthorName = authorName;
        Status = status;

    }
    //incremented
    public Integer Id;
    public String Title;
    public String AuthorName;
    public Availability Status;
}


 enum Availability {
     RETURNED, BORROWED;
 }

