package com.example.demo.contracts;

import com.example.demo.screen.InventoryMainScreen;

public interface  IInventoryMainScreen extends IMainScreen {
    InventoryMainScreen.InventoryActions ACTIONS = InventoryMainScreen.InventoryActions.INCREASEDINVENTORY;
}
