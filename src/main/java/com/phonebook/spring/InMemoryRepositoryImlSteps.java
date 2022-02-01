package com.phonebook.spring;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InMemoryRepositoryImlSteps {

    public String phoneValidation(String phone){
        /**
         * let's say, that the length of the number is supposed to be 11digits and a plus sign in the beginning of it
         */
        if(phone.length()!=12 || !Pattern.matches("\\+[0-9]+", phone)){
            throw new IllegalArgumentException
                    ("Provided number should consist of a \'+\' sign followed by 11 digits, e.g: +12345678901");
        }
        try{
            Long.parseLong(phone.substring(1));
        } catch (NumberFormatException e){
            e.printStackTrace();
        } finally {
            return phone;
        }
    }
    public String nameValidation(String name){

        String returnValue = name;
        char beginning = name.charAt(0);
        try{
            if(Character.isLowerCase(beginning)){
               char c =  Character.toUpperCase(returnValue.charAt(0));
               returnValue = c + name.substring(1).toLowerCase(Locale.ROOT);
            }
            if(name.matches("[A-Z]{1}[a-z]+")){
                return returnValue;
            } else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }


}
