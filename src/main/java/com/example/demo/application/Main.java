package com.example.demo.application;

import com.example.demo.application.inventory.InventoryManagement;
import com.example.demo.application.library.LibraryManagement;
import com.example.demo.contracts.IInventoryMainScreen;
import com.example.demo.contracts.ILibraryMainScreen;
import com.example.demo.contracts.IMainProgramScreen;
import com.example.demo.contracts.IMainScreen;
import com.example.demo.infrastructure.DataProvider;
import com.example.demo.models.AppConfiguration;
import com.example.demo.screen.InventoryMainScreen;
import com.example.demo.screen.LibraryMainScreen;
import com.example.demo.screen.MainProgramScreen;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void Run(Scanner scanner, AppConfiguration configuration, DataProvider dataProvider,MainProgramScreen mainProgramScreen) throws IOException {

        mainProgramScreen.DisplayMainScreen();
        var input = mainProgramScreen.PromptUserInput(scanner);

        var action = mainProgramScreen.ACTIONS;
        if(action.LIBRARYSYSTEM.getIdentifier() == input){
            IMainScreen mainScreen = new LibraryMainScreen();
            LibraryManagement system =  new LibraryManagement(scanner,configuration,dataProvider, (ILibraryMainScreen) mainScreen);
            system.RunProgram();
        }else if(action.INVENTORYSYSTEM.getIdentifier() == input){
            IMainScreen mainScreen = new InventoryMainScreen();
            InventoryManagement system =  new InventoryManagement(scanner,configuration,dataProvider, (IInventoryMainScreen) mainScreen);
            system.RunProgram();
        }
    }
}
