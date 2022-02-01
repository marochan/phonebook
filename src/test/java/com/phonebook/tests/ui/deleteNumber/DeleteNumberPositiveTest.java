package com.phonebook.tests.ui.deleteNumber;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.phonebook.tests.ui.base.BaseTest;
import com.phonebook.tests.ui.steps.TestSteps;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Map;
import java.util.Set;

public class DeleteNumberPositiveTest extends TestSteps {
    @Test
    public void deleteNumber() throws JsonProcessingException {
        driver.findElement(By.linkText("Add a new number")).click();

        String contactName = nameValidation(generateParameter(10,"name"));
        String contactPhone =  generateParameter(11, "phone");
        add(contactName, contactPhone);

        Assert.assertEquals("The title of this page didnt match the expected one","Phonebook homepage", driver.getTitle());
        driver.findElement(By.linkText("Delete a number")).click();
        Assert.assertEquals("The title of this page didnt match the expected one","Delete a number", driver.getTitle());
        Assert.assertEquals("The actual url is different from the on expected", "http://localhost:8080/api/v1/customers/delete", driver.getCurrentUrl());

        By deleteName =  By.xpath("//input[@id='name']");
        By deleteButton = By.xpath("//input[@type='submit']");


        driver.findElement(deleteName).sendKeys(contactName);
        driver.findElement(deleteButton).click();
        Assert.assertEquals("The title of this page didnt match the expected one","Phonebook homepage", driver.getTitle());
        driver.findElement(By.linkText("See all contacts")).click();
        WebElement body = driver.findElement(By.tagName("pre"));
        String bodyString = body.getText();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Set<String>> map = mapper.readValue(bodyString, new TypeReference<Map<String, Set<String>>>() {
        });
        Assert.assertFalse("The phonebook is not supposed to store the name but it does",map.containsKey(contactName));
        int isDataSorted = checkIfMapIsSorted(map);
        Assert.assertEquals(0, isDataSorted);
    }
}
