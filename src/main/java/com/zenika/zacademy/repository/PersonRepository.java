package com.zenika.zacademy.repository;

import com.zenika.zacademy.model.Person;

import java.util.Optional;
import java.util.Set;

public interface PersonRepository {
    /**
     * Permet de récupérer toutes les personnes dans l'annuaire en base de données
     *
     * @return l'annuaire complet
     */
    Set<Person> getDirectory();

    /**
     * Permet de rechercher une personne dans l'annuaire via son nom et / ou son prénom
     *
     * @param searchedName le nom et / ou le prénom de la personne
     * @return un optionnel de personne
     */
    Optional<Person> findByName(String searchedName);
}
