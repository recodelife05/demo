package com.example.demo;

public interface ILibraryMainScreen {

    void DisplayMainScreen();
    void DisplayEndScreen();
    void DisplayInvalidScreen();
    void DisplayErrorScreen();
    LibraryMainScreen.LibraryActions ACTIONS = LibraryMainScreen.LibraryActions.ADDBOOK;
}
