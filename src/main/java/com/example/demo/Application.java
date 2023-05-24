package com.example.demo;

import com.example.demo.application.Main;
import com.example.demo.contracts.IMainProgramScreen;
import com.example.demo.infrastructure.DataProvider;
import com.example.demo.infrastructure.contracts.IDataProvider;
import com.example.demo.models.AppConfiguration;
import com.example.demo.screen.MainProgramScreen;

import java.io.IOException;
import java.util.Scanner;

public class Application {

    void Start() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        AppConfiguration configuration = new AppConfiguration();
        IDataProvider dataProvider = new DataProvider();
        configuration.IsPersist = true;
        IMainProgramScreen mainProgramScreen = new MainProgramScreen();
        Main.Run(scanner,configuration, (DataProvider) dataProvider,(MainProgramScreen) mainProgramScreen);
    }
}
