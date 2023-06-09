package com.example.demo;

import com.example.demo.application.Main;
import com.example.demo.application.inventory.InventoryManagement;
import com.example.demo.contracts.IInventoryMainScreen;
import com.example.demo.contracts.IMainProgramScreen;
import com.example.demo.contracts.IMainScreen;
import com.example.demo.screen.InventoryMainScreen;
import com.example.demo.screen.LibraryMainScreen;
import com.example.demo.application.library.LibraryManagement;
import com.example.demo.infrastructure.contracts.IDataProvider;
import com.example.demo.contracts.ILibraryMainScreen;
import com.example.demo.infrastructure.DataProvider;
import com.example.demo.models.AppConfiguration;
import com.example.demo.screen.MainProgramScreen;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, InterruptedException {

        var app = new com.example.demo.Application();
        app.Start();
    }

    public class MyClass {
        public static void main(String args[]) {






        }

        public  void RunSomething(){
            //1. LAZY DOG LAZY DOGGIE L
            String text = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";

            System.out.println(text.toLowerCase());
            //2. multiply 2 numbers
            //TODO: create an input number 1 and inpunt number 2 to the function of multiply number
            //https://beginnersbook.com/2017/09/java-program-to-read-integer-value-from-the-standard-input/
            MultiplyNumber(25,25);

            //3.) enter the number of times it will multiply.
            //TODO: crete input prompt to user
            int muliplier = 10;
            int size = 10;
            PrintMultiplicationTable(size,muliplier);


            //4.) 4 number valid numbers other not.

            int numbers[] = {25,25,26,25};
            var isValid =  IsValidEqualNumbers(numbers);
            PrintAnswer(isValid);


            //5. double between 0 and 1
            double dNumbers[] = {-0.5,2.6};
            TestDNumbers(dNumbers);
        }

        //test double numbers.
        public static void TestDNumbers(double dNumbers[]) {
            boolean Result = true;
            for(int i = 0; i < dNumbers.length; i++){
                var isValid = TestDoubleNumbersBetweenZeroAndOne(dNumbers[i]);

                if(!isValid){
                    Result = false;
                    break;
                }

            }
            System.out.println(Result);
        }

        //test if number is between zero and less than 1
        public static boolean TestDoubleNumbersBetweenZeroAndOne(double num){
            boolean isValid = false;
            if(num > 0 && num < 1){
                isValid = true;
            }

            return isValid;
        }

        //multiply 2 numbers
        public static void MultiplyNumber(int number,int multipler){
            MultiplyFormatter(number,multipler);
        }

        // mulitplication table
        public static void PrintMultiplicationTable(int number,int muliplier){
            for(int i = 0; i <= number; i++) {
                for(int j = 0; j <= muliplier; j++){
                    MultiplyFormatter(i,j);
                }
                System.out.println("------ end of line " + i +  " ------");
            }
        }

        //format to print the mulitiplication table
        public static void MultiplyFormatter(int number,int multiplier){
            System.out.println(number + "*" + multiplier + "=" + number * multiplier);
        }
        //4.
        //enter four number all are equals.
        public static boolean IsValidEqualNumbers(int[] numbers){
            boolean isValid = true;
            int sum = 0;

            //iterates input numbers
            for(int i = 0; i < numbers.length - 1; i++){

                // compares the current number to next number if not equal return false, break the loop;
                // i + 1 is the next number on the array.
                if(numbers[i] != numbers[i + 1]){
                    isValid = false;
                    break;
                }
            }
            return isValid;
        }

        //format of if inputted numbers are eqal or not.
        public static void PrintAnswer(boolean IsValid){
            String result = IsValid ? "" : "not ";
            System.out.println( "Numbers are " + result + "equal");
        }


    }

}