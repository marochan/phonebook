package com.phonebook.tests.base;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class DeleteNumberTest extends BaseTest{
    @Test
    public void deleteNumber(){
        Assert.assertEquals("The title of this page didnt match the expected one","Phonebook homepage", driver.getTitle());
        driver.findElement(By.linkText("Delete a number")).click();
        Assert.assertEquals("The title of this page didnt match the expected one","Delete a number", driver.getTitle());
        Assert.assertEquals("The actual url is different from the on expected", "http://localhost:8080/api/v1/customers/delete", driver.getCurrentUrl());

        By name =  By.xpath("//input[@id='name']");
        By deleteButton = By.xpath("//input[@type='submit']");

        driver.findElement(name).sendKeys("Cezary");
        driver.findElement(deleteButton).click();
    }
}
