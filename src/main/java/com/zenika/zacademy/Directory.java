package com.zenika.zacademy;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Directory {
    private Set<Person> persons = new HashSet<>();

    public Set<Person> getPersons() {
        return persons;
    }

    public void addUnique(Person newPerson) {
        persons.add(newPerson);
    }

    public Optional<Person> searchByName(String searchedName) {
        String searchNameLowerCase = searchedName.toLowerCase();
        return persons.stream()
                .filter((currentPerson) ->
                        searchNameLowerCase.contains(currentPerson.firstName) || searchNameLowerCase.contains(currentPerson.lastName)
                ).findFirst();
    }

}
