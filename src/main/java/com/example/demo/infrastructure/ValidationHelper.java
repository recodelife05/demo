package com.example.demo.infrastructure;

public class ValidationHelper {
    public static Boolean Validate(String someText){
        try {
            int parseInt =  Integer.parseInt(someText);
            return false;
        } catch (NumberFormatException ex) {
            return true;
        }
    }
}
