package com.phonebook.model;

import com.phonebook.customAnnotations.annotations.ValidName;
import org.jetbrains.annotations.NotNull;



public class Deletion {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ValidName
    String name;

}
