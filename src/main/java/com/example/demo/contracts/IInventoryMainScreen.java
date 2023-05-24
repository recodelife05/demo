package com.example.demo.contracts;

import com.example.demo.screen.InventoryMainScreen;

import java.util.Scanner;

public interface  IInventoryMainScreen extends IMainScreen {

    void DisplayToContinue();
    void DisplayExitingProgram() throws InterruptedException;
    Integer PromptUserInput(Scanner scanner);
    InventoryMainScreen.InventoryActions ACTIONS = InventoryMainScreen.InventoryActions.INCREASEDINVENTORY;
}
