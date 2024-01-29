package com.zenika.zacademy.repository;

import com.zenika.zacademy.model.Person;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.zenika.zacademy.mock.PersonMock.generateFakePerson;
@Repository

/**
 * Représente une base de données in memory pour la gestion des personnes
 * Quand le programme s'arrête, toutes les données générées sont supprimées
 */
public class InMemoryPersonRepository implements PersonRepository {
    private static final int NUMBER_OF_DATA = 60;
    // Représente ma base de données
    private final Set<Person> directory = new HashSet<>();

    public InMemoryPersonRepository() {

        // Initialisation des données
        for (int i = 0; i < NUMBER_OF_DATA; i++) {
            Person newPerson = generateFakePerson();
            directory.add(newPerson);
        }
    }

    public Set<Person> getDirectory() {
        return directory;
    }

    @Override
    public Optional<Person> findByName(String searchedName) {
        String searchNameLowerCase = searchedName.toLowerCase();
        return this.directory.stream()
                .filter((currentPerson) ->
                        searchNameLowerCase.contains(currentPerson.firstName) || searchNameLowerCase.contains(currentPerson.lastName)
                ).findFirst();
    }
}
