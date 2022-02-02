package com.phonebook.spring;

import java.util.regex.Pattern;

public class InMemoryRepositoryImlSteps {

    public String nameformatter(String name){

        StringBuilder builder = new StringBuilder();

        builder.append(Character.toUpperCase(name.charAt(0)));
        for(int i = 1; i < name.length();i++){
            char c = name.charAt(i);
            if(Character.isUpperCase(c)){
                builder.append(Character.toLowerCase(c));
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }


}
