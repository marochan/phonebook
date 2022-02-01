package com.phonebook.model;


import org.jetbrains.annotations.NotNull;

public class Record {
    @NotNull
    private String name;
    @NotNull
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
