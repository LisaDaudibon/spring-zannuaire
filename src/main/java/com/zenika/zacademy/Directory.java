package com.zenika.zacademy;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Directory {
    private Set<Promotion> promotions = new HashSet<>();
    private Set<Person> persons = new HashSet<>();

    public Set<Person> getPersons() {
        return persons;
    }

    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public void addUniquePerson(Person newPerson) {
        persons.add(newPerson);
    }

    public Optional<Person> searchPersonByName(String searchedName) {
        String searchNameLowerCase = searchedName.toLowerCase();
        return persons.stream()
                .filter((currentPerson) ->
                        searchNameLowerCase.contains(currentPerson.firstName) || searchNameLowerCase.contains(currentPerson.lastName)
                ).findFirst();
    }

    public Promotion searchPromotionById(int searchedId) throws PromotionNotFoundException {
        for (Promotion currentPromotion : promotions) {
            if (currentPromotion.getId() == searchedId) {
                return currentPromotion;
            }
        }

        throw new PromotionNotFoundException("Can not found any Promotion with id " + searchedId);
    }
}
