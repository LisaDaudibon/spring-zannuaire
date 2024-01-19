package com.zenika.zacademy;

import com.zenika.zacademy.exception.NotFoundException;
import com.zenika.zacademy.exception.PersonNotFoundException;
import com.zenika.zacademy.exception.PromotionNotFoundException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final Directory zAcademyDirectory = new Directory();

    public static void main(String[] args) {
        // Création des données personnes
        Student marina = new Student("Marina", "Assohoun", "0601020304", "Rue de dinan", "marinadu93@gmail.com");
        Former karine = new Former("Karine", "Sabatier", "0701020304", "Rue de rennes", "karineagile4ever@yahoo.fr");
        Student yassir = new Student("Yassir", "LastName", "0709087098", "rue de londres", "yassiroklm@gmail.com");

        // Ajout des personnes à l'annuaire
        zAcademyDirectory.addUniquePerson(karine);
        zAcademyDirectory.addUniquePerson(marina);
        zAcademyDirectory.addUniquePerson(yassir);

        // Création des promotions
        Set<Former> javatarFormers = new HashSet<>();
        javatarFormers.add(karine);

        Set<Student> javatarStudents = new HashSet<>();
        javatarStudents.add(marina);

        Promotion javatar = new Promotion(9, "javatar", javatarFormers, javatarStudents);

        Set<Former> javenturierFormers = new HashSet<>();
        javenturierFormers.add(karine);

        Set<Student> javenturierStudents = new HashSet<>();
        javenturierStudents.add(yassir);

        Promotion javenturier = new Promotion(8, "javenturier", javenturierFormers, javenturierStudents);

        // Ajout des promotions à l'annuaire
        zAcademyDirectory.getPromotions().add(javatar);
        zAcademyDirectory.getPromotions().add(javenturier);

        // Début du programme
        System.out.println("""
                Vous pouvez rechercher:
                  - Un formateur ou un élève via un nom et / ou prénom (insensible à la casse)
                  - Une promotion via un numéro de promotion
                  - La liste des promotions en tapant promotions
                    """);

        boolean isRunning = true;
        while (isRunning) {
            String userSearch = null;
            System.out.println("Veuillez taper votre recherche ou q pour sortir:");
            try {
                // Cas d'une recherche par numéro de promotion
                if (scanner.hasNextInt()) {
                    displayPromotionById(scanner.nextInt());
                    continue;
                }

                userSearch = scanner.nextLine();

                if (userSearch.equals("q")) {
                    System.out.println("Merci d'avoir utilisé le service zAcademyAnnuaire. Des bsx");
                    isRunning = false;
                    continue;
                }

                // Cas d'affichage des promotions
                if (userSearch.equals("promotions")) {
                    displayPromotions();
                    continue;
                }

                // cas d'affichage d'une personne par nom
                displayPersonByName(userSearch);
            } catch (NotFoundException exception) {
                System.out.printf("Aucune donnée trouvée pour %s la recherche %s %n", exception.className, userSearch);
            } catch (Exception exception) {
                System.out.println("Il semble y avoir un souci, veuillez réessayer. :/");
            } finally {
                scanner.close();
            }
        }

    }

    private static void displayPromotions() {
        System.out.println(zAcademyDirectory.getPromotions());
    }

    private static void displayPersonByName(String userSearch) throws PersonNotFoundException {
        Optional<Person> person = zAcademyDirectory.searchPersonByName(userSearch);
        if (person.isPresent()) {
            System.out.println(person.get());
        } else {
            throw new PersonNotFoundException("search by name " + userSearch);
        }
    }

    static void displayPromotionById(int searchId) throws PromotionNotFoundException {
        Promotion promotion = zAcademyDirectory.searchPromotionById(searchId);
        System.out.println(promotion);
    }
}
