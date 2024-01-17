package com.zenika.zacademy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DirectoryTest {

    private final Person karine = new Former("Karine", "Sabatier", "0701020304", "Rue de rennes", "karineagile4ever@yahoo.fr");
    private final Person marina = new Student("Marina", "Assohoun", "0601020304", "Rue de dinan", "marinadu93@gmail.com");
    private final Directory directory = new Directory();

    @BeforeEach
    void setupTest() {
        directory.getPersons().clear();
    }

    @Nested
    class addUnique {
        @Test
        @Order(1)
        @DisplayName("Ajoute une personne dans la liste de notre annuaire")
        void shouldAddPersonInList() {
            directory.addUnique(karine);
            assertTrue(directory.getPersons().contains(karine));
        }

        @Test
        @Order(2)
        void shouldAddTwoDifferentPersonsInListIfEmailNotEquals() {
            directory.addUnique(karine);
            directory.addUnique(marina);
            assertEquals(2, directory.getPersons().size());
        }

        @Test
        @Order(3)
        void shouldNotAddPersonInListIfEmailAlreadyExits() {
            directory.addUnique(karine);
            directory.addUnique(karine);
            assertEquals(1, directory.getPersons().size());
        }
    }
}