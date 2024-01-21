package com.zenika.zacademy.service;

import com.zenika.zacademy.exception.PersonNotFoundException;
import com.zenika.zacademy.model.Person;
import com.zenika.zacademy.repository.PersonRepository;

public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person findByName(String searchedName) throws PersonNotFoundException {
        return repository.findByName(searchedName).orElseThrow(() -> new PersonNotFoundException("search by name " + searchedName));
    }
}
