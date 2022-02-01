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

public class DeleteNumberNegativeTest extends TestSteps {
    @Test
    public void deleteNumber() throws JsonProcessingException {
        Assert.assertEquals("The title of this page didnt match the expected one","Phonebook homepage", driver.getTitle());
        driver.findElement(By.linkText("Delete a number")).click();
        Assert.assertEquals("The title of this page didnt match the expected one","Delete a number", driver.getTitle());
        Assert.assertEquals("The actual url is different from the on expected", "http://localhost:8080/api/v1/customers/delete", driver.getCurrentUrl());

        By name =  By.xpath("//input[@id='name']");
        By deleteButton = By.xpath("//input[@type='submit']");
        String nameToBeDeleted = nameValidation(generateParameter(10,"name"));

        driver.findElement(name).sendKeys(nameToBeDeleted);
        driver.findElement(deleteButton).click();
        Assert.assertEquals("The title of this page didnt match the expected one","Phonebook homepage", driver.getTitle());

    }
}
