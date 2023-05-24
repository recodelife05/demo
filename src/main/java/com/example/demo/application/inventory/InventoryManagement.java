package com.example.demo.application.inventory;
import com.example.demo.contracts.IInventoryMainScreen;
import com.example.demo.infrastructure.ValidationHelper;
import com.example.demo.infrastructure.contracts.IDataProvider;
import com.example.demo.models.AppConfiguration;

import java.io.IOException;
import java.util.Scanner;

public class InventoryManagement extends InventoryManager {

    private static Scanner _scanner;
    private IInventoryMainScreen _mainScreen;
    public InventoryManagement(Scanner scanner, AppConfiguration appConfig,
                             IDataProvider dataProvider, IInventoryMainScreen mainScreen) throws IOException {
        super(appConfig,scanner,dataProvider);
        _scanner = scanner;
        _mainScreen = mainScreen;
    }
    public void RunProgram() throws IOException, InterruptedException {
        ControlFlow(_scanner);
    }
    private void ControlInput(Character input){
        var ACTIONS = _mainScreen.ACTIONS;
        if(ACTIONS.getIdentifier() == input){

        }else if(ACTIONS.LISTOFINVETORY.getIdentifier() == input) {
            DisplayAll();
        }else if(ACTIONS.REMOVEDINVENTORY.getIdentifier() == input) {
            var id = _mainScreen.PromptUserInput(_scanner);
            if(id == 0){
                _mainScreen.DisplayInvalidScreen();
            }else {
                RemovedInventory(id);
            }
        }else if(ACTIONS.EXITPROGRAM.getIdentifier() == input) {
            _mainScreen.DisplayEndScreen();
            System.exit(1);
        }else {
            _mainScreen.DisplayInvalidScreen();
        }
    }
    private void ControlFlow(Scanner sc) throws InterruptedException {
        try{
            var ACTIONS = _mainScreen.ACTIONS;
            _mainScreen.DisplayMainScreen();
            while(true){
                var input = sc.nextLine();
                //if valid
                var IsValid = false;
                IsValid = ValidationHelper.Validate(input);

                if(IsValid){
                    ControlInput(input.toUpperCase().charAt(0));
                }else {
                    _mainScreen.DisplayInvalidScreen();
                }
            }
        }catch (Exception ex){
            _mainScreen.DisplayErrorScreen();
            _mainScreen.DisplayToContinue();
            var answer =  sc.nextLine();
            if(answer.toString().isBlank() || answer.toString().isEmpty() || answer.equals(null)){
                _mainScreen.DisplayExitingProgram();
            }else if(answer.charAt(0) == 'Y'){
                ControlFlow(sc);
            }else {
                _mainScreen.DisplayExitingProgram();
            }
        }
    }
}
