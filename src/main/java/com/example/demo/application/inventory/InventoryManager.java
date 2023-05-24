package com.example.demo.application.inventory;

import com.example.demo.infrastructure.contracts.IDataProvider;
import com.example.demo.models.AppConfiguration;
import com.example.demo.models.Availability;
import com.example.demo.models.Book;
import com.example.demo.models.Inventory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManager {

    ArrayList<Inventory> datasource = new ArrayList<Inventory>();
    IDataProvider _dataProvider;
    Scanner _scanner;
    InventoryManager(AppConfiguration config, Scanner scanner, IDataProvider provider) throws IOException {
        _dataProvider = provider;
        _scanner = scanner;
        if(config.IsPersist){
        //    listOfInventory =  _dataProvider.GetRecordsFromTextFile();
            datasource = _dataProvider.GetInventories();
        }else {
            datasource = _dataProvider.GetInventories();
        }
    }

    public void DisplayAll(){
        System.out.println("LIST OF INVENTORIES");
        datasource.stream()
                .map(r -> "Inventory Id: " + r.Id.toString() + " Name: " + r.Name + ", Status: " +  r.Status + ", Quantity: "  + r.Quantity)
                .forEach(p ->  System.out.println(p));
    }


}
