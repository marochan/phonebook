package com.phonebook.tests.ui.base;

import com.phonebook.tests.ui.runner.TestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.TestPropertySource;

@RunWith(TestRunner.class)
@TestPropertySource("classpath:application.properties")
public class BaseTest {
    protected  WebDriver driver;

    @Value("${registrationRef}")
    protected String registrationRef;

    @Value("${registrationUrl}")
    protected String registrationURL;

    @Value("${deletionRef}")
    protected String deletionRef;

    @Value("${deletionUrl}")
    protected String deletionURL;

    @Before
    public   void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/crokita/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/api/v1/customers");
    }
    @Test
    public void print(){
        System.out.println(this.registrationRef);
        System.out.println(this.registrationURL);
        System.out.println(this.deletionRef);
        System.out.println(this.deletionURL);
    }
    @After
    public   void tearDown(){
        driver.quit();
    }


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertiesResolver() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
