package com.example.demo.contracts;

import com.example.demo.screen.LibraryMainScreen;

public interface ILibraryMainScreen extends  IMainScreen {

    void DisplayMainScreen();
    void DisplayEndScreen();
    void DisplayInvalidScreen();
    void DisplayErrorScreen();
    LibraryMainScreen.LibraryActions ACTIONS = LibraryMainScreen.LibraryActions.ADDBOOK;
}
