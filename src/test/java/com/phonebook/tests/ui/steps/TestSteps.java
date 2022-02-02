package com.phonebook.tests.ui.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.phonebook.tests.ui.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class TestSteps extends BaseTest {
    public String generateParameter(int targetLength, String type) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        switch (type) {
            case "phone": {
                stringBuilder.append('+');
                for (int i = 0; i < targetLength; i++) {
                    int rand = random.nextInt(9);
                    stringBuilder.append(rand);
                }
                return stringBuilder.toString();
            }
            case "name": {
                int left = 97;
                int right = 122;
                for (int i = 0; i < targetLength; i++) {
                    int randomLimitedInt = left + (int) (random.nextFloat() * (right - left + 1));
                    stringBuilder.append((char) randomLimitedInt);
                }
                return stringBuilder.toString();
            }
            case "invalidName":{
                int left = 123;
                int right = 125;
                for (int i = 0; i < targetLength; i++) {
                    int randomLimitedInt = left + (int) (random.nextFloat() * (right - left + 1));
                    stringBuilder.append((char) randomLimitedInt);
                }
                return stringBuilder.toString();
            }
            default:
                throw new IllegalArgumentException("The parameter provided by user has not been found");

        }

    }
    public String nameValidation(String name){

        String returnValue = name;
        char beginning = name.charAt(0);
        try{
            if(Character.isLowerCase(beginning)){
                char c =  Character.toUpperCase(returnValue.charAt(0));
                returnValue = c + name.substring(1).toLowerCase(Locale.ROOT);
            }
            if(name.matches("[A-Z]{1}[a-z]+")){
                return returnValue;
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return returnValue;
    }

    public void add(String contactName, String contactPhone){
        By name = By.xpath("//input[@id='name']");
        By phone = By.xpath("//input[@id='phone']");
        By submitButton = By.xpath("//input[@type='submit']");

        driver.findElement(name).sendKeys(contactName);
        driver.findElement(phone).sendKeys(contactPhone);
        driver.findElement(submitButton).click();
    }

    public Map<String, Set<String>> seeAllContacts() throws JsonProcessingException {
        driver.get(baseURL);
        driver.findElement(By.linkText("See all contacts")).click();
        WebElement body = driver.findElement(By.tagName("pre"));
        String bodyString = body.getText();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Set<String>> map = mapper.readValue(bodyString, new TypeReference<Map<String, Set<String>>>() {
        });
        return map;
    }

    public int checkIfMapIsSorted(Map<String, Set<String>> map) throws JsonProcessingException {

        Object[] keys = map.keySet().toArray();
        for(int i = 1; i < keys.length; i++){
            if(keys[i].toString().compareTo(keys[i-1].toString()) < 0){
                System.out.println("Map is not sorted properly");
                return -1;
            }
        }
        System.out.println("Map is sorted properly");
        return 0;
    }

    public void assertsOnHomepageThenAddNumber(String toClick, String url, String pageTtitle) throws InterruptedException {

        Assert.assertEquals("The title of this page didnt match the expected one","Phonebook homepage", driver.getTitle());
        driver.findElement(By.linkText(toClick)).click();
        WebElement element =  driver.findElement(By.tagName("body"));
        System.out.println(element.getText());
        Assert.assertEquals("The title of this page didnt match the expected one",pageTtitle, driver.getTitle());
        Assert.assertEquals("The actual url is different from the on expected", url, driver.getCurrentUrl());

    }
}
