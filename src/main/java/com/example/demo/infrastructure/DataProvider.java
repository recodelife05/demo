package com.example.demo.infrastructure;

import com.example.demo.infrastructure.contracts.IDataProvider;
import com.example.demo.models.Availability;
import com.example.demo.models.Book;
import com.example.demo.models.Inventory;
import com.example.demo.models.StockLevel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataProvider implements IDataProvider {
    ArrayList<Book> listOfBooks = new ArrayList<Book>();
    ArrayList<Inventory> inventories = new ArrayList<Inventory>();
    @Override
    public ArrayList<Book> GetRecords() {
        System.out.println("Initializing Library System");
        System.out.println("Adding Books on the system");
        Book book1 = new Book(1,"Book 1","Author", Availability.BORROWED);
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

    public  ArrayList<Inventory> GetInventories(){
        System.out.println("Initializing Inventory System");
        System.out.println("Adding Inventories on the system");

        Inventory inv = new Inventory(1,100,"T-Shirts");
        Inventory inv1 = new Inventory(2,0,"Shorts");
        Inventory inv2 = new Inventory(3,4,"Caps");
        Inventory inv3 = new Inventory(4,50,"Underwear");
        Inventory inv4 = new Inventory(5,76,"Nike Air force 1");
        inventories.add(inv);
        inventories.add(inv1);
        inventories.add(inv2);
        inventories.add(inv3);
        inventories.add(inv4);

        return  inventories;
    }

}
