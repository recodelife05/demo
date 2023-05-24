package com.example.demo.archive;

import java.util.*;
public class MyClass {
    public static void main(String args[]) {

        //1.
        ToLowerCaseString();

        //2. multiply 2 numbers
        MultiplyTwoNumbers();

        //3.) enter the number of times it will multiply.
        CreateMultiplicationTable();

        //4.) 4 number valid numbers other not.
        //initialized 4 numbers to input
        DisplayEnterANumbersOfEqualNumbers(3);

        //5. double between 0 and 1
        DisplayResultIfNumbersAreBetweenZeroAndOne();

    }

    //1
    public  static void ToLowerCaseString(){
        System.out.println("turns string to lower case");
        System.out.println("Enter a upper case string: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(input.toLowerCase());
    }

    //2
    public  static void MultiplyTwoNumbers(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Multiply two numbers");
        try {
            System.out.print("Enter first number- ");
            int a= sc.nextInt();
            System.out.print("Enter second number- ");
            int b= sc.nextInt();

            MultiplyNumber(a,b);

        }catch (Exception ex){
            System.out.println("Invalid args " + ex.getMessage());
        }
    }

    public  static void CreateMultiplicationTable(){

        System.out.println("Multiplication table");
        Scanner sc1= new Scanner(System.in);
        System.out.print("Enter size of table- ");
        int multiplier = sc1.nextInt();
        int size = 10;
        PrintMultiplicationTable(size,multiplier);
    }

    public static void DisplayEnterANumbersOfEqualNumbers(int size){

        System.out.println("Enter 4 integer numbers are all equal");
        int sizeOf = size;
        int numbers[] =new int[sizeOf];;
        int i = 0;
        //bug here
        Scanner screen4= new Scanner(System.in);
        System.out.println("Enter the number:- ");
        while(screen4.hasNext()){
            System.out.println("Enter the next number:- ");
            int s = screen4.nextInt();
            if(i == 3){
                break;
            }
            numbers[i] = s;
            System.out.println("you have entered: " + numbers[i]);

            i++;
        }
        // int numbers[] = {25,25,26,25};
        var isValid =  IsValidEqualNumbers(numbers);
        PrintAnswer(isValid);
    }

    public  static void DisplayResultIfNumbersAreBetweenZeroAndOne(){
        System.out.println("Enter a double number between 0 and 1");
        Scanner screen5 = new Scanner(System.in);
        System.out.println("Enter the 1st number:- ");
        double d1 = screen5.nextDouble();
        System.out.println("Enter the 2nd number:- ");
        double d2 = screen5.nextDouble();
        double dNumbers[] = {d1,d2};
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
        //iterates input numbers
        for(int i = 0; i < numbers.length - 1; i++){

            // compares the current number to next number if not equal return false, break the loop;
            // i + 1 is the next number on the array.
            System.out.println(numbers[i] + " !=  " + numbers[i + 1]);
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