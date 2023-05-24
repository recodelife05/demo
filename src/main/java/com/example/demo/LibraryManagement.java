package com.example.demo;
import java.io.*;
import java.util.*;

public class LibraryManagement extends ManageLibrary {
    private static Scanner _scanner;
    private ILibraryMainScreen _mainScreen;
    LibraryManagement(Scanner scanner,AppConfiguration appConfig,IDataProvider dataProvider,ILibraryMainScreen mainScreen) throws IOException {
        super(appConfig,scanner,dataProvider);
        _scanner = scanner;
        _mainScreen = mainScreen;
    }
    public void RunProgram() throws IOException {
        ControlFlow(_scanner);
    }
    private void RunLibrary(Character input){
        var ACTIONS = _mainScreen.ACTIONS;
        if(ACTIONS.ADDBOOK.getIdentifier() == input){
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
                IsValid = TryParseInt(input);

                if(IsValid){
                    RunLibrary(input.toUpperCase().charAt(0));
                }else {
                    _mainScreen.DisplayInvalidScreen();
                }
            }
        }catch (Exception ex){
            _mainScreen.DisplayErrorScreen();
            throw ex;
        }
    }
    private Boolean TryParseInt(String someText) {
        try {
            int parseInt =  Integer.parseInt(someText);
            return false;
        } catch (NumberFormatException ex) {
            return true;
        }
    }


}

