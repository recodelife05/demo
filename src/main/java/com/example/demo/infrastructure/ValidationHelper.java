package com.example.demo.infrastructure;

public class ValidationHelper {
    public static Boolean Validate(String someText){

        if(someText.isEmpty() || someText.equals(null) || someText.isBlank()){
            return  false;
        }

        try {
            int parseInt =  Integer.parseInt(someText);
            return false;
        } catch (NumberFormatException ex) {
            return true;
        }
    }
}
