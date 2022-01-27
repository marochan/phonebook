package com.phonebook.main;

import com.phonebook.spring.ApplicationConfig;
import com.phonebook.spring.PhoneBook;
import com.phonebook.spring.PhoneBookFormatter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * PhoneBook entry point
 */
@SpringBootApplication
@ComponentScan("com.phonebook")
public class PhoneBookApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PhoneBookApplication.class, args);
    }
}
