package com.phonebook.tests.ui.addNumber;

import com.phonebook.tests.ui.base.BaseTest;
import com.phonebook.tests.ui.steps.TestSteps;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class AddNumberNegativeTest extends TestSteps {
    @Test
    public void addNumberFailure(){
        Assert.assertEquals("The title of this page didnt match the expected one","Phonebook homepage", driver.getTitle());
        driver.findElement(By.linkText("Add a new number")).click();
        Assert.assertEquals("The title of this page didnt match the expected one","Phonebook homepage", driver.getTitle());
        Assert.assertEquals("The actual url is different from the on expected", "http://localhost:8080/api/v1/customers/registration", driver.getCurrentUrl());


        String contactName = generateParameter(10,"invalidName");
        String contactPhone = generateParameter(3, "phone");
        System.out.println("Contact name: " + contactName);
        System.out.println("Contact phone: " + contactPhone  );
        add(contactName, contactPhone);
        Assert.assertEquals("The title of this page didnt match the expected one","Phonebook homepage", driver.getTitle());


    }
}
