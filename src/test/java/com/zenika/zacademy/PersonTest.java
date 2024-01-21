package com.zenika.zacademy;

import com.zenika.zacademy.model.Former;
import com.zenika.zacademy.model.Person;
import com.zenika.zacademy.model.Student;
import com.zenika.zacademy.repository.InMemoryPersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonTest {

    private final Former karine = new Former("Karine", "Sabatier", "0701020304", "Rue de rennes", "karineagile4ever@yahoo.fr");
    private final Student marina = new Student("Marina", "Assohoun", "0601020304", "Rue de dinan", "marinadu93@gmail.com");

    private final InMemoryPersonRepository repository = new InMemoryPersonRepository();

    @BeforeEach
    void setupTest() {
        repository.getDirectory().clear();
    }

    @Test
    void shouldFormatMessageForFormer() {
        Former karine = new Former("Karine", "Sabatier", "0701020304", "Rue de rennes", "karineagile4ever@yahoo.fr");
        assertEquals("Formateur karine sabatier\n" +
                "\uD83D\uDCF1: 0701020304\n" +
                "\uD83D\uDCE7: karineagile4ever@yahoo.fr\n" +
                "\uD83C\uDFE0: Rue de rennes".trim(), karine.toString().trim());
    }

    @Test
    void shouldFormatMessageForStudent() {
        Student marina = new Student("Marina", "Assohoun", "0601020304", "Rue de dinan", "marinadu93@gmail.com");
        assertEquals("Élève marina assohoun\n" +
                "\uD83D\uDCF1: 0601020304\n" +
                "\uD83D\uDCE7: marinadu93@gmail.com\n" +
                "\uD83C\uDFE0: Rue de dinan\n".trim(), marina.toString().trim());
    }

    @Nested
    class addUnique {
        @Test
        @Order(1)
        @DisplayName("Ajoute une personne dans la liste de notre annuaire")
        void shouldAddPersonInList() {
            repository.getDirectory().add(karine);
            assertTrue(repository.getDirectory().contains(karine));
        }

        @Test
        @Order(2)
        void shouldAddTwoDifferentPersonsInListIfEmailNotEquals() {
            repository.getDirectory().add(karine);
            repository.getDirectory().add(marina);
            assertEquals(2, repository.getDirectory().size());
        }

        @Test
        @Order(3)
        void shouldNotAddPersonInListIfEmailAlreadyExits() {
            repository.getDirectory().add(karine);
            repository.getDirectory().add(karine);
            assertEquals(1, repository.getDirectory().size());
        }
    }

    @Nested
    class searchByName {

        @Test
        void shouldReturnPersonByFirstNameIfExists() {
            repository.getDirectory().add(karine);
            Optional<Person> personFound = repository.findByName("Karine");
            assertEquals(karine, personFound.get());
        }

        @Test
        void shouldReturnPersonByLastNameIfExists() {
            repository.getDirectory().add(karine);
            Optional<Person> personFound = repository.findByName("Sabatier");
            assertEquals(karine, personFound.get());
        }

        @Test
        void shouldReturnPersonByFirstNameAndLastNameIfExists() {
            repository.getDirectory().add(karine);
            Optional<Person> personFound = repository.findByName("Karine Sabatier");
            assertEquals(karine, personFound.get());
        }

        @Test
        void shouldReturnPersonByFirstNameAndLastNameWithoutCaseSensitiveIfExists() {
            repository.getDirectory().add(karine);
            Optional<Person> personFound = repository.findByName("KarINe SABatier");
            assertEquals(karine, personFound.get());
        }

        @Test
        void shouldReturnNullIfPersonNotFound() {
            repository.getDirectory().add(karine);
            Optional<Person> personFound = repository.findByName("Xavier");
            assertTrue(personFound.isEmpty());
        }
    }

}