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
    public void deleteNumber() throws JsonProcessingException, InterruptedException {
        driver.findElement(By.linkText("Add a new number")).click();

        String contactName = nameValidation(generateParameter(10,"name"));
        String contactPhone =  generateParameter(11, "phone");
        add(contactName, contactPhone);

        assertsOnHomepageThenAddNumber(deletionRef, deletionURL, "Delete a number");
        By deleteName =  By.xpath("//input[@id='name']");
        By deleteButton = By.xpath("//input[@type='submit']");

        driver.findElement(deleteName).sendKeys(contactName);
        driver.findElement(deleteButton).click();
        Assert.assertEquals("The title of this page didnt match the expected one","Phonebook homepage", driver.getTitle());
        Map<String,Set<String>> map = seeAllContacts();
        Assert.assertFalse("The phonebook is not supposed to store the name but it does",map.containsKey(contactName));
        int isDataSorted = checkIfMapIsSorted(map);
        Assert.assertEquals(0, isDataSorted);
    }
}
