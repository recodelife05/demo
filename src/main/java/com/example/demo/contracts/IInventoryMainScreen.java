package com.example.demo.contracts;

import com.example.demo.screen.InventoryMainScreen;

import java.util.Scanner;

public interface  IInventoryMainScreen extends IMainScreen {


    Integer PromptUserInput(Scanner sc);
    InventoryMainScreen.InventoryActions ACTIONS = InventoryMainScreen.InventoryActions.INCREASEDINVENTORY;
}
