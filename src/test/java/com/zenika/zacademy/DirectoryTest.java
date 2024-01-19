package com.zenika.zacademy;

import com.zenika.zacademy.exception.PromotionNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class DirectoryTest {

    private final Former karine = new Former("Karine", "Sabatier", "0701020304", "Rue de rennes", "karineagile4ever@yahoo.fr");
    private final Student marina = new Student("Marina", "Assohoun", "0601020304", "Rue de dinan", "marinadu93@gmail.com");
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
            directory.addUniquePerson(karine);
            assertTrue(directory.getPersons().contains(karine));
        }

        @Test
        @Order(2)
        void shouldAddTwoDifferentPersonsInListIfEmailNotEquals() {
            directory.addUniquePerson(karine);
            directory.addUniquePerson(marina);
            assertEquals(2, directory.getPersons().size());
        }

        @Test
        @Order(3)
        void shouldNotAddPersonInListIfEmailAlreadyExits() {
            directory.addUniquePerson(karine);
            directory.addUniquePerson(karine);
            assertEquals(1, directory.getPersons().size());
        }
    }

    @Nested
    class searchByName {

        @Test
        void shouldReturnPersonByFirstNameIfExists() {
            directory.addUniquePerson(karine);
            Optional<Person> personFound = directory.searchPersonByName("Karine");
            assertEquals(karine, personFound.get());
        }

        @Test
        void shouldReturnPersonByLastNameIfExists() {
            directory.addUniquePerson(karine);
            Optional<Person> personFound = directory.searchPersonByName("Sabatier");
            assertEquals(karine, personFound.get());
        }

        @Test
        void shouldReturnPersonByFirstNameAndLastNameIfExists() {
            directory.addUniquePerson(karine);
            Optional<Person> personFound = directory.searchPersonByName("Karine Sabatier");
            assertEquals(karine, personFound.get());
        }

        @Test
        void shouldReturnPersonByFirstNameAndLastNameWithoutCaseSensitiveIfExists() {
            directory.addUniquePerson(karine);
            Optional<Person> personFound = directory.searchPersonByName("KarINe SABatier");
            assertEquals(karine, personFound.get());
        }

        @Test
        void shouldReturnNullIfPersonNotFound() {
            directory.addUniquePerson(karine);
            Optional<Person> personFound = directory.searchPersonByName("Xavier");
            assertTrue(personFound.isEmpty());
        }
    }

    @Nested
    class searchPromotionById {

        private Set<Former> formers = new HashSet<>() {
            {
                add(karine);
            }
        };

        private Set<Student> students = new HashSet<>() {
            {
                add(marina);
            }
        };

        private Promotion promotion = new Promotion(9, "Javatar", LocalDate.of(2022, 12, 15), formers, students);

        // Ce BeforeEach sera exécuté avant chaque test présent dans la classe searchPromotionById
        @BeforeEach
        void setup() {
            directory.getPromotions().clear();
            directory.getPromotions().add(promotion);
        }

        @Test
        void shouldFoundPromotionById() throws PromotionNotFoundException {
            Promotion promotion = directory.searchPromotionById(9);
            assertNotNull(promotion);
        }

        @Test
        void shouldNotFoundPromotionById() {
            assertThrows(PromotionNotFoundException.class, () -> {
                directory.searchPromotionById(1);
            });
        }
    }
}