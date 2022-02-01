package com.phonebook.spring;

import com.phonebook.main.InMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

/**
 * PhoneBook service implementation
 */
@Service
public class PhoneBook {

    @Autowired
    private InMemoryRepository repository;

    public PhoneBook() {
        // be careful this.repository will not be initialised if injection on setter is chosen
    }

    /**
     * injection is supported on constructor level.
     *
     * @param repository
     */
    // @Autowired
    public PhoneBook(InMemoryRepository repository) {
        this.repository = repository;
    }

    /**
     * injection is supported on setter level
     *
     * @param repository
     */
    public void setRepository(InMemoryRepository repository) {
        this.repository = repository;
    }

    /**
     * @return all pairs of type {name: [phone1, phone2]}
     */
    public Map<String, Set<String>> findAll() {
        return repository.findAll();
    }

    /**
     * TODO: please add required methods here
     */
    public void addPhone(String name, String phone){
        repository.addPhone(name, phone);
    }
    public Set<String> findAllPhonesByName(String name) {
        return repository.findAllPhonesByName(name);
    }

    public String findNameByPhone(String phone) throws Exception{
        return repository.findNameByPhone(phone);
    }

    public void removePhone(String phone){
        repository.removePhone(phone);
    }

    public void deleteRecord(String name){
        repository.deleteRecord(name);
    }
    public void sortPhoneBookByName(Map<String, Set<String>> data) {
        data.entrySet().stream()
                .sorted(Map.Entry.<String, Set<String>>comparingByKey());
    }
}
