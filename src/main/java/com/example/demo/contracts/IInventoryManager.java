package com.example.demo.contracts;

import com.example.demo.models.Inventory;

public interface IInventoryManager {

    void IncreasedInventory(Integer inventoryId,Integer IncreasedBy);
    void DecresedInventory(Integer inventoryId,Integer DecreasedBy);
    void AddInventory(Inventory inventory);
    void RemovedInventory(Integer Id);
    void DisplayAll();
}
