package com.phonebook.tests.ui.addNumber;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.phonebook.tests.ui.steps.TestSteps;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Map;
import java.util.Set;

public class AddNumberPositiveTest extends TestSteps {
    @Test
    public void addNumber() throws JsonProcessingException {
        Assert.assertEquals("The title of this page didnt match the expected one","Phonebook homepage", driver.getTitle());
        driver.findElement(By.linkText("Add a new number")).click();
        Assert.assertEquals("The title of this page didnt match the expected one","Phonebook homepage", driver.getTitle());
        Assert.assertEquals("The actual url is different from the on expected", "http://localhost:8080/api/v1/customers/registration", driver.getCurrentUrl());

        String contactName = nameValidation(generateParameter(10,"name"));
        String contactPhone =  generateParameter(11, "phone");
        add(contactName,contactPhone);

        Assert.assertEquals("The title of this page didnt match the expected one","Phonebook homepage", driver.getTitle());
        driver.findElement(By.linkText("See all contacts")).click();
        WebElement body = driver.findElement(By.tagName("pre"));
        String bodyString = body.getText();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Set<String>> map = mapper.readValue(bodyString, new TypeReference<Map<String, Set<String>>>() {
        });
        System.out.println("Contact name: " + contactName);
        System.out.println("Contact phone: " + contactPhone  );
        System.out.println(map);
        Assert.assertTrue("The phonebook is supposed to store the name but it does not",map.containsKey(contactName));
        Assert.assertTrue("The phone number should be saved to the contact name but it was not", map.get(contactName).contains(contactPhone));
        int isDataSorted = checkIfMapIsSorted(map);
        Assert.assertEquals(0, isDataSorted);
    }


}
