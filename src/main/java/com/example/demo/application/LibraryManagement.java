package com.example.demo.application;
import com.example.demo.infrastructure.ValidationHelper;
import com.example.demo.infrastructure.contracts.IDataProvider;
import com.example.demo.contracts.ILibraryMainScreen;
import com.example.demo.models.AppConfiguration;
import com.example.demo.models.Availability;

import java.io.*;
import java.util.*;

public class LibraryManagement extends ManageLibrary {
    private static Scanner _scanner;
    private ILibraryMainScreen _mainScreen;
    public LibraryManagement(Scanner scanner, AppConfiguration appConfig,
                             IDataProvider dataProvider, ILibraryMainScreen mainScreen) throws IOException {
        super(appConfig,scanner,dataProvider);
        _scanner = scanner;
        _mainScreen = mainScreen;
    }
    public void RunProgram() throws IOException {
        ControlFlow(_scanner);
    }
    private void ControlInput(Character input){
        var ACTIONS = _mainScreen.ACTIONS;
        if(ACTIONS.getIdentifier() == input){
            AddBook();
        }else if(ACTIONS.REMOVEDBOOK.getIdentifier() == input) {
            RemoveBook();
        }else if(ACTIONS.BORROWBOOK.getIdentifier() == input){
            ChangeStatusOfABook(Availability.BORROWED);
        }else if(ACTIONS.RETURNEDBOOK.getIdentifier() == input){
            ChangeStatusOfABook(Availability.RETURNED);
        }else if(ACTIONS.LISTOFBORROWEDBOOKS.getIdentifier() == input){
            DisplayBooks(Availability.BORROWED);
        }else if(ACTIONS.LISTRETURNEDBOOKS.getIdentifier() == input){
            DisplayBooks(Availability.RETURNED);
        }else if(ACTIONS.DISPLAYALLBOOKS.getIdentifier() == input){
            DisplayAllBooks();
        } else if(ACTIONS.EXITPROGRAM.getIdentifier() == input) {
            _mainScreen.DisplayEndScreen();
            System.exit(1);
        }else {
            _mainScreen.DisplayInvalidScreen();
        }
    }
    private void ControlFlow(Scanner sc){
        try{
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
            throw ex;
        }
    }

}

