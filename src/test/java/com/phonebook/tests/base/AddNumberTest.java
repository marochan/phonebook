package com.phonebook.tests.base;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class AddNumberTest extends BaseTest{
    @Test
    public void addNumber(){
        Assert.assertEquals("The title of this page didnt match the expected one","Phonebook homepage", driver.getTitle());
        driver.findElement(By.linkText("Add a new number")).click();
        Assert.assertEquals("The title of this page didnt match the expected one","Phonebook homepage", driver.getTitle());
        Assert.assertEquals("The actual url is different from the on expected", "http://localhost:8080/api/v1/customers/registration", driver.getCurrentUrl());

        By name = By.xpath("//input[@id='name']");
        By phone = By.xpath("//input[@id='phone']");
        By submitButton = By.xpath("//input[@type='submit']");
       driver.findElement(name).sendKeys("Cezary");
        driver.findElement(phone).sendKeys("112324124");
        driver.findElement(submitButton).click();


    }
}
