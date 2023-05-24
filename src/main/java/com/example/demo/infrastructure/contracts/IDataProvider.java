package com.example.demo.infrastructure.contracts;

import com.example.demo.models.Book;
import com.example.demo.models.Inventory;

import java.util.ArrayList;

public interface IDataProvider {

    public ArrayList<Book> GetRecords();
    public  ArrayList<Book> GetRecordsFromTextFile();

    public  ArrayList<Inventory> GetInventories();
}
