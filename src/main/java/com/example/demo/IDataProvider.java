package com.example.demo;

import java.util.ArrayList;

public interface IDataProvider {

    public ArrayList<Book> GetRecords();
    public  ArrayList<Book> GetRecordsFromTextFile();
}
