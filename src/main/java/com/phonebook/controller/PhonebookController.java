package com.phonebook.controller;

import com.phonebook.model.Deletion;
import com.phonebook.model.Record;
import com.phonebook.spring.PhoneBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;
import java.util.Set;

@Controller
public class PhonebookController {

    @Autowired
    private PhoneBook phonebook;

    @GetMapping("/")
    public String welcome() {
        return "index";
    }

    @GetMapping("/phonebook")
    public ResponseEntity<Map<String, Set<String>>> getFullPhoneBook() {
        return ResponseEntity.ok(phonebook.findAll());
    }

    @GetMapping("/phonebook/{name}")
    public ResponseEntity<Set<String>> findPhonesByname(@PathVariable("name") String name) throws Exception{
        return ResponseEntity.ok(phonebook.findAllPhonesByName(name));
    }

    @GetMapping("/registration")
    public String getRegistration(@ModelAttribute("record") Record registration) {
        return "registration";
    }

    @PostMapping("/registration")
    public String createNewRecordInPhonebook(@Valid @ModelAttribute("record") Record registration, BindingResult result) {
        if (result.hasErrors()){
            System.out.println("Error while loading page");
            result.getAllErrors().stream().forEach(x-> System.out.println(x));
            return "registration";
        }
        String name = registration.getName();
        String phone = registration.getPhone();
        System.out.println(name);
        System.out.println(phone);
        phonebook.addPhone(name, phone);

        return "index";
    }

    @GetMapping("/delete")
    public String getDeletePage(@ModelAttribute("deletion") Deletion deletion) {
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@Valid @ModelAttribute("deletion")  Deletion deletion, BindingResult result) {
        if(result.hasErrors()){
            System.out.println("Error while loading page");
            return "delete";
        }
        String name = deletion.getName();
        if(phonebook.deleteRecord(name)==-1){
            return "deleteError";
        } else {
            return "index";
        }


    }
    //validating if the string provided is actually a number
    //alphabetical order of the phonebook
    //validation if the number was added to the phonebook
    //negative test
}
