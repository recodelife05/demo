package com.example.demo.contracts;

import com.example.demo.models.Availability;

public interface IManageLibrary {

    void AddBook();
    void RemoveBook();
    void ChangeStatusOfABook(Availability status);
    void DisplayBooks(Availability status);
    void DisplayAllBooks();
}
