package com.phonebook.main;

import com.phonebook.spring.ApplicationConfig;
import com.phonebook.spring.PhoneBook;
import com.phonebook.spring.PhoneBookFormatter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

/**
 * PhoneBook entry point
 */
public class PhoneBookMain {

    public static void main(String[] args) {
        ApplicationContext context = newApplicationContext(args);

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter(System.getProperty("line.separator"));

        PhoneBook phoneBook = context.getBean("phoneBook", PhoneBook.class);
        PhoneBookFormatter renderer = (PhoneBookFormatter) context.getBean("phoneBookFormatter");

        renderer.info("type 'exit' to quit.");
        renderer.info("Type 'ADD' to add a phone number");
        renderer.info("Type 'REMOVE_PHONE' to remove a phone from the database");
        renderer.info("Type 'SHOW' to show phonebook");
        while(true){
            while (sc.hasNext()) {
                String line = sc.nextLine();
                if (line.equals("exit")) {
                    renderer.info("Have a good day...");
                    break;
                }
                try {
                    // TODO: add your code here
                    // throw new UnsupportedOperationException("Implement it!");
                    if(line.equals("ADD")){
                        String name = sc.next();
                        String phone = sc.next();
                        phoneBook.addPhone(name, phone);
                        renderer.show(phoneBook.findAll());
                        break;
                    } else if(line.equals("REMOVE_PHONE")){
                        String phoneToBeRemoved = sc.next();
                        phoneBook.removePhone(phoneToBeRemoved);
                        renderer.show(phoneBook.findAll());
                        break;
                    } else if (line.equals("SHOW")){
                        renderer.show(phoneBook.findAll());
                        break;
                    }

                } catch (Exception e) {
                    renderer.error(e);
                }
            }
        }

    }

    static ApplicationContext newApplicationContext(String... args) {
        return args.length > 0 && args[0].equals("classPath")
                ? new ClassPathXmlApplicationContext("application-config.xml")
                : new AnnotationConfigApplicationContext(ApplicationConfig.class);
    }

}
