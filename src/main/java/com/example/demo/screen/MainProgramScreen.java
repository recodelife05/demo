package com.example.demo.screen;

import com.example.demo.contracts.IMainProgramScreen;
import com.example.demo.infrastructure.ValidationHelper;

import java.util.Scanner;
import java.util.stream.Stream;

public class MainProgramScreen implements IMainProgramScreen {

    public Character PromptUserInput(Scanner sc){
        var userInput = sc.nextLine();
        var IsValid = false;
        IsValid = ValidationHelper.Validate(userInput);
        return userInput.toUpperCase().charAt(0);
    }
    public void DisplayMainScreen(){
        ApplicationSystem.stream().
                forEach(r -> System.out.println("Press <" + r.getIdentifier() + "> to " + r.description));
    }
    public void DisplayEndScreen() {
        System.out.println("Thank you for using our Library System.");
    }
    public void DisplayInvalidScreen(){
        System.out.println("Please enter correct choice.");
    }
    @Override
    public void DisplayErrorScreen() { System.out.println("Something went wrong."); }
    public enum ApplicationSystem {
        LIBRARYSYSTEM('A',"LIBRARY SYSTEM"),
        INVENTORYSYSTEM('B',"INVENTORY SYSTEM"),
        EXITPROGRAM('X',"Exit Program");
        ApplicationSystem(Character identifier,String description){
            this.identifier = identifier;
            this.description = description;
        };
        private Character identifier;
        private String description;
        public Character getIdentifier(){
            return  identifier;
        }
        public static Stream<ApplicationSystem> stream() {
            return Stream.of(ApplicationSystem.values());
        }

    }
}
