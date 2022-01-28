package com.phonebook.controller;

import com.phonebook.model.Deletion;
import com.phonebook.model.Record;
import com.phonebook.spring.PhoneBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public ResponseEntity<Set<String>> findPhonesByname(@PathVariable("name") String name) {
        return ResponseEntity.ok(phonebook.findAllPhonesByName(name));
    }

    @GetMapping("/registration")
    public String getRegistration(@ModelAttribute("record") Record registration) {
        return "registration";
    }

    @PostMapping("/registration")
    public String createNewRecordInPhonebook(@ModelAttribute("record") Record registration) {
        String name = registration.getName();
        String phone = registration.getPhone();
        phonebook.addPhone(name, phone);
        return "index";
    }

    @GetMapping("/delete")
    public String getDeletePage(@ModelAttribute("deletion") Deletion deletion) {
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("deletion") Deletion deletion, RedirectAttributes redirectAttributes) {
        String name = deletion.getName();
        redirectAttributes.addAttribute("name", name);
        return "redirect:/delete/{name}";
    }

    @GetMapping("/delete/{name}")
    public String deletion(){
        return "redirecting";
    }

    @DeleteMapping("/delete/{name}")
    public String deleteRecordByName(@PathVariable("name") String name){
        phonebook.deleteRecord(name);
        return "index";
    }
}
