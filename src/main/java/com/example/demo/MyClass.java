package com.example.demo;

import java.util.*;
public class MyClass {
    public static void main(String args[]) {

        //1. LAZY DOG LAZY DOGGIE L
        String text = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";

        System.out.println(text.toLowerCase());
        //2. multiply 2 numbers
        //TODO: create an input number 1 and inpunt number 2 to the function of multiply number
        //https://beginnersbook.com/2017/09/java-program-to-read-integer-value-from-the-standard-input/

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter first number- ");
        int a= sc.nextInt();
        System.out.print("Enter second number- ");
        int b= sc.nextInt();

        MultiplyNumber(a,b);

        //3.) enter the number of times it will multiply.
        //TODO: crete input prompt to user
        Scanner sc1= new Scanner(System.in);
        System.out.print("Enter size of table- ");
        int sz = sc1.nextInt();
        int muliplier = sz;
        int size = 10;
        PrintMultiplicationTable(size,muliplier);


        //4.) 4 number valid numbers other not.
        //Scanner sc= new Scanner(System.in);
        //System.out.print("Enter first number- ");
        //int a= sc.nextInt();
        //System.out.print("Enter second number- ");
        //int b= sc.nextInt();

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