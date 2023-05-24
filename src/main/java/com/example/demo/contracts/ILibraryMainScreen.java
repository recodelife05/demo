package com.example.demo.contracts;

import com.example.demo.application.LibraryMainScreen;

public interface ILibraryMainScreen {

    void DisplayMainScreen();
    void DisplayEndScreen();
    void DisplayInvalidScreen();
    void DisplayErrorScreen();
    LibraryMainScreen.LibraryActions ACTIONS = LibraryMainScreen.LibraryActions.ADDBOOK;
}
