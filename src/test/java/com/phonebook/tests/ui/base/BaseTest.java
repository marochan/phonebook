package com.phonebook.tests.ui.base;

import com.phonebook.spring.PhoneBook;
import com.phonebook.tests.ui.runner.TestRunner;
import com.phonebook.tests.ui.steps.TestSteps;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(TestRunner.class)
public class BaseTest {
    protected  WebDriver driver;

    @Before
    public   void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/crokita/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/api/v1/customers");

    }
    @After
    public   void tearDown(){
        driver.quit();
    }



}
