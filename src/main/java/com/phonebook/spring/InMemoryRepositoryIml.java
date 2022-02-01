package com.phonebook.spring;

import com.phonebook.main.InMemoryRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Keeps phoneBook data in memory in ordered in accordance to addition.
 */
@Repository
public class InMemoryRepositoryIml extends InMemoryRepositoryImlSteps implements InMemoryRepository {

    private Map<String, Set<String>> data;
    private PhoneBookFormatter formatter;

    /**
     * no args constructor
     */
    public InMemoryRepositoryIml() {
        // LinkedHashMap is chosen because usually iteration order matters
        this(new LinkedHashMap<>());
    }

    /**
     * this constructor allows to inject initial data to the repository
     *
     * @param data
     */
    public InMemoryRepositoryIml(Map<String, Set<String>> data) {
        this.data = new LinkedHashMap<>(data);
    }

    @Override
    public Map<String, Set<String>> findAll() {
        return new LinkedHashMap<>(this.data);
    }

    @Override
    public Set<String> findAllPhonesByName(String nameToValidate) {

        String name = nameValidation(nameToValidate);
        boolean isNameFound = data.containsKey(name);
        if (!isNameFound) {
            throw new IllegalArgumentException("Name has not been found in the phonebook");
        } else {
            return this.data.get(name);
        }
    }

    @Override
    public String findNameByPhone(String phone) {

        phoneValidation(phone);
        for (Map.Entry<String, Set<String>> entry : data.entrySet()) {
            if (entry.getValue().contains(phone)) {
                return entry.getKey();
            }
        }
        return "Provided phone number could not be found in the database";
    }

    @Override
    public void addPhone(String nameToValidate, String phoneToValidate) {
        String name = nameValidation(nameToValidate);
        if (name == null) {
            throw new IllegalArgumentException("Name should only consist of letters");
        }
        String phone = phoneValidation(phoneToValidate);
        try {
            data.computeIfAbsent(name, v -> new HashSet<String>()).add(phone);
            sortPhoneBookByName();
            System.out.println("Number: " + phone + " has been added for user: " + name);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removePhone(String phone) throws IllegalArgumentException {
        boolean phoneIsPresent = false;

        for (Map.Entry<String, Set<String>> entry : data.entrySet()) {
            String name = entry.getKey();
            Set<String> phoneNumbers = entry.getValue();
            if (phoneNumbers.remove(phone)) {
                phoneIsPresent = true;
                System.out.println("Removing: " + phone);
                if (phoneNumbers.isEmpty()) {
                    data.remove(name);
                    sortPhoneBookByName();
                    System.out.println("No more numbers present, removing user: " + name);
                }
                break;
            }
        }
        if (phoneIsPresent == false) {
            throw new IllegalArgumentException("Provided phone number has not been found in the database!");
        }
    }

    @Override
    public void deleteRecord(String nameToValidate) throws IllegalArgumentException {
        String name = nameValidation(nameToValidate);

        if (data.remove(name) == null) {
            throw new NullPointerException("Provided number has not been found in the phonebook");
        } else {
            sortPhoneBookByName();
            System.out.println("User:" + name + "has been deleted from the phonebook");
        }
    }

    public void sortPhoneBookByName() {

        List<String> keys = new ArrayList<String>(data.keySet());
        Collections.sort(keys);
        LinkedHashMap<String, Set<String>> newData = new LinkedHashMap<String, Set<String>>();
        for (String s : keys) {
            newData.put(s, data.get(s));
        }
        data = newData;
    }
}
