package com.phonebook.tests.ui.base;

import com.phonebook.spring.ApplicationConfig;
import com.phonebook.tests.ui.runner.TestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application.properties")
@SpringBootTest(classes = ApplicationConfig.class)
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

    @Value("${baseURL}")
    protected String baseURL;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/crokita/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get(baseURL);
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
