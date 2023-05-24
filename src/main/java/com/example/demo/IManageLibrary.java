package com.example.demo;

public interface IManageLibrary {

    void AddBook();
    void RemoveBook();
    void ChangeStatusOfABook(Availability status);
    void DisplayBooks(Availability status);
    void DisplayAllBooks();
}
