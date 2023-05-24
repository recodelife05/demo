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

    public  String DisplayImplement(Boolean flag){
        return  flag == true ? "online" : "offline";
    }
    public void DisplayEndScreen() {
        System.out.println("Thank you for using our Library System.");
    }
    public void DisplayInvalidScreen(){
        System.out.println("Please enter correct choice.");
    }
    @Override
    public void DisplayErrorScreen() { System.out.println("Something went wrong."); }
    public enum InventoryActions {
        ADDINVENTORY('A',"Add a Inventory",true),
        INCREASEDINVENTORY('B',"Increased Inventory",false),
        DECREASEDINVENTORY('C',"Decreased Inventory",false),
        REMOVEDINVENTORY('D',"Removed a Inventory",false),
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
