package com.example.demo.screen;

import com.example.demo.contracts.IInventoryMainScreen;
import com.example.demo.infrastructure.ValidationHelper;

import java.util.Scanner;
import java.util.stream.Stream;

public class InventoryMainScreen implements IInventoryMainScreen {
    public void DisplayMainScreen(){
       InventoryActions.stream().
                 map(r -> "Press <" + r.getIdentifier() + "> to " + r.description + " (" + DisplayImplement(r.IsImplemented) + ")").
                forEach(o -> System.out.println(o));
    }

    public Integer PromptUserInput(Scanner sc){
        var userInput = sc.nextLine();
        var IsValid = false;
        IsValid = ValidationHelper.Validate(userInput);
        if(!IsValid){
            return Integer.parseInt(userInput);
        }else {
            return  0;
        }
    }

    public String PromptUserInputString(Scanner sc) {
        var userInput = sc.nextLine();
        var IsValid = false;
        IsValid = ValidationHelper.Validate(userInput);
        if(!IsValid){
            return userInput;
        }else {
            return  "";
        }
    }

    public  String DisplayImplement(Boolean flag){
        return  flag == true ? "online" : "offline";
    }
    public void DisplayEndScreen() {
        System.out.println("Thank you for using our Library System.");
    }
    public void DisplayInvalidScreen(){
        System.out.println("Please enter correct choice.");
    }

    public void DisplayPleaseEnterTheInventoryId(){
        System.out.println("Please enter inventory id.");
    }
    public void DisplayToContinue() {
        System.out.println("Do you wish to continue: Y/N");
    }

    public  void DisplayExitingProgram() throws InterruptedException {
        System.out.println("Exiting in 5 seconds");
        long WAIT_TIME = 5000;
        Thread.sleep(WAIT_TIME);
        System.out.println("Thank you!");
        System.exit(1);
    }
    @Override
    public void DisplayErrorScreen() { System.out.println("Something went wrong."); }
    public enum InventoryActions {
        ADDINVENTORY('A',"Add a Inventory",true),
        INCREASEDINVENTORY('B',"Increased Inventory",false),
        DECREASEDINVENTORY('C',"Decreased Inventory",false),
        REMOVEDINVENTORY('D',"Removed a Inventory",true),
        LISTOFINVETORY('E',"List of Inventory",true),
        EXITPROGRAM('X',"Exit Program",true);
        InventoryActions(Character identifier,String description,Boolean IsImplemented){
            this.identifier = identifier;
            this.description = description;
            this.IsImplemented = IsImplemented;
        };
        private Character identifier;
        private String description;

        public Boolean IsImplemented;
        public Character getIdentifier(){
            return  identifier;
        }
        public static Stream<InventoryActions> stream() {
            return Stream.of(InventoryActions.values());
        }

    }
}
