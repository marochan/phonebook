package com.phonebook.model;


import com.phonebook.customAnnotations.annotations.ValidName;
import com.phonebook.customAnnotations.annotations.ValidPhone;

import javax.validation.constraints.NotEmpty;


public class Record {

    @NotEmpty
    @ValidName
    private String name;

    @NotEmpty
    @ValidPhone
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
