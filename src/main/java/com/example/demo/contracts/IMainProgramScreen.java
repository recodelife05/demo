package com.example.demo.contracts;

import com.example.demo.screen.InventoryMainScreen;
import com.example.demo.screen.MainProgramScreen;

import java.util.Scanner;

public interface IMainProgramScreen extends IMainScreen {

    Character PromptUserInput(Scanner sc);
    MainProgramScreen.ApplicationSystem ACTIONS = MainProgramScreen.ApplicationSystem.LIBRARYSYSTEM;
}
