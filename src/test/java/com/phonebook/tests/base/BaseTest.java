package com.phonebook.tests.base;

import com.phonebook.tests.listener.TestListener;
import com.phonebook.tests.runner.TestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
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
