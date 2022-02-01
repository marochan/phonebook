package com.phonebook.tests.ui;

import com.phonebook.spring.ApplicationConfig;
import com.phonebook.spring.PhoneBook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})

public class PhoneBookTest {

    @Test
    public void test(){
        System.out.println(" ");
    }

    @Autowired
    private PhoneBook phoneBook;

    // TODO: implement a couple of tests for PhoneBook.class
    @Test
    public void get_person_phone_numbers() {
        final Set<String> expected = new HashSet<>(asList("+7960123223"));
        assertEquals("phone numbers do not match",
                expected,
                phoneBook.findAll().get("Alex"));
    }

    @Test
    public void add_person_to_phonebook(){
        String name = "James";
        String[] numbers = {"+123456789", "+1122334455", "089043433"};
        for(int i = 0; i < numbers.length; i++) {
            phoneBook.addPhone(name, numbers[i]);
        }
        final Set<String> expected = new HashSet<>(asList("+123456789", "+1122334455", "089043433"));
        assertEquals("phone number does not match", expected, phoneBook.findAll().get(name));
    }

    @Test
    public void remove_newly_added_person() {

        String name = "James";
        String phone = "+123456789";
        phoneBook.addPhone(name, phone);
        assertFalse("User added to the database",
                phoneBook.findAll().get(name).contains(phone));

        phoneBook.removePhone(phone);
        assertFalse(phoneBook.findAll().containsKey(name));
        phoneBook.removePhone(phone);
    }



}
