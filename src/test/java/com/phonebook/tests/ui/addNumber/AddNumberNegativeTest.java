package com.phonebook.tests.ui.addNumber;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.phonebook.tests.ui.base.BaseTest;
import com.phonebook.tests.ui.steps.TestSteps;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Map;
import java.util.Set;

public class AddNumberNegativeTest extends TestSteps {

    @Test
    public void print(){
    }
    @Test
    public void addNumberFailure() throws JsonProcessingException, InterruptedException {

        assertsOnHomepageThenAddNumber(registrationRef, registrationURL);

        String contactName = generateParameter(10,"invalidName");
        String contactPhone = generateParameter(3, "phone");
        System.out.println("Contact name: " + contactName);
        System.out.println("Contact phone: " + contactPhone  );

        add(contactName, contactPhone);
        Assert.assertEquals("The title of this page didnt match the expected one","Phonebook homepage", driver.getTitle());
        driver.navigate().back();

        Map<String, Set<String>> map = seeAllContacts();
        Assert.assertTrue("The name has not been addded to the phonebook", map.containsKey(contactName));
    }
}
