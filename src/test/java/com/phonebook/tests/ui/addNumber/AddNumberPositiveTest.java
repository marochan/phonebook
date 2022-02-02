package com.phonebook.tests.ui.addNumber;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.phonebook.tests.ui.steps.TestSteps;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;
import java.util.Set;

public class AddNumberPositiveTest extends TestSteps {


    @Test
    public void addNumber() throws JsonProcessingException, InterruptedException {


        assertsOnHomepageThenAddNumber(registrationRef,registrationURL,"Phonebook homepage" );
        String contactName = nameValidation(generateParameter(10,"name"));
        String contactPhone =  generateParameter(11, "phone");
        add(contactName,contactPhone);

        Assert.assertEquals("The title of this page didnt match the expected one","Phonebook homepage", driver.getTitle());

        Map<String,Set<String>> map = seeAllContacts();
        System.out.println("Contact name: " + contactName);
        System.out.println("Contact phone: " + contactPhone  );
        System.out.println(map);
        Assert.assertTrue("The phonebook is supposed to store the name but it does not",map.containsKey(contactName));
        Assert.assertTrue("The phone number should be saved to the contact name but it was not", map.get(contactName).contains(contactPhone));
        int isDataSorted = checkIfMapIsSorted(map);
        Assert.assertEquals(0, isDataSorted);
    }


}
