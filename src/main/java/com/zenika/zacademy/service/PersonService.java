package com.zenika.zacademy.service;

import com.zenika.zacademy.exception.PersonNotFoundException;
import com.zenika.zacademy.model.Person;
import com.zenika.zacademy.repository.InMemoryRepository;

import java.util.Optional;

public class PersonService {

    private final InMemoryRepository repository;

    public PersonService(InMemoryRepository repository) {
        this.repository = repository;
    }

    public Person findByName(String searchedName) throws PersonNotFoundException {
        Optional<Person> person = repository.getAcademyDirectory().searchPersonByName(searchedName);
        if (person.isPresent()) {
            return person.get();
        } else {
            throw new PersonNotFoundException("search by name " + searchedName);
        }
    }
}
