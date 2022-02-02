package com.phonebook.tests.ui.addNumber;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.phonebook.tests.ui.steps.TestSteps;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Map;
import java.util.Set;

public class AddNumberNegativeTest extends TestSteps {


    @Test
    public void addNumberFailure() throws JsonProcessingException, InterruptedException {

        assertsOnHomepageThenAddNumber(registrationRef,registrationURL, "Phonebook homepage" );
        String contactName = generateParameter(10,"invalidName");
        String contactPhone = generateParameter(3, "phone");
        System.out.println("Contact name: " + contactName);
        System.out.println("Contact phone: " + contactPhone  );

        add(contactName, contactPhone);

        Assert.assertTrue("The name error does not exist but it should",driver.findElements( By.xpath("//span[@id='name.errors']") ).size() != 0);
        Assert.assertTrue("This phone error does not exist but it should",driver.findElements( By.xpath("//span[@id='phone.errors']") ).size() != 0);
        driver.navigate().back();
        Map<String, Set<String>> map = seeAllContacts();
        Assert.assertTrue("The name has not been addded to the phonebook", map.containsKey(contactName));
    }
}
