package com.zenika.zacademy;

import java.util.HashSet;
import java.util.Set;

public class Directory {
    private Set<Person> persons = new HashSet<>();

    public Set<Person> getPersons() {
        return persons;
    }

    public void addUnique(Person newPerson) {
        persons.add(newPerson);
    }
}
