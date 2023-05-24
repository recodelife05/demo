package com.example.demo.application.inventory;

import com.example.demo.contracts.IInventoryManager;
import com.example.demo.infrastructure.contracts.IDataProvider;
import com.example.demo.models.AppConfiguration;
import com.example.demo.models.Availability;
import com.example.demo.models.Book;
import com.example.demo.models.Inventory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class InventoryManager implements IInventoryManager {

    ArrayList<Inventory> datasource = new ArrayList<Inventory>();
    IDataProvider _dataProvider;
    Scanner _scanner;
    InventoryManager(AppConfiguration config, Scanner scanner, IDataProvider provider) throws IOException {
        _dataProvider = provider;
        _scanner = scanner;
        if(config.IsPersist){
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


    public void IncreasedInventory(Integer inventoryId,Integer IncreasedBy) {
           var inventory = GetById(inventoryId);
            if(inventory != null){
                inventory.Quantity += IncreasedBy;
            }
    }

    public void DecresedInventory(Integer inventoryId,Integer DecreasedBy) {
        var inventory = GetById(inventoryId);
        if(inventory != null){
            inventory.Quantity -= DecreasedBy;
        }
    }

    public void AddInventory(Inventory inventory) {
        inventory.Id = GetLatestSeedId() + 1;
        datasource.add(inventory);
    }
    public void RemovedInventory(Integer inventoryId) {
        var inventoryToRemoved = datasource.stream().filter(r -> r.Id == inventoryId).findFirst().get();
        datasource.remove(inventoryToRemoved);
    }

    private Inventory GetById(Integer inventoryId){
        return  datasource.stream().filter(r->r.Id == inventoryId).findFirst().get();
    }
    private Integer GetLatestSeedId(){
       return  datasource.stream().map(r-> r.Id).max(Integer::compare).get();
    }
}
