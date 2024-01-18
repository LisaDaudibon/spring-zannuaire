package com.zenika.zacademy;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Student marina = new Student("Marina", "Assohoun", "0601020304", "Rue de dinan", "marinadu93@gmail.com");
        Former karine = new Former("Karine", "Sabatier", "0701020304", "Rue de rennes", "karineagile4ever@yahoo.fr");
        Student yassir = new Student("Yassir", "LastName", "0709087098", "rue de londres", "yassiroklm@gmail.com");

        Directory zAcademyDirectory = new Directory();
        zAcademyDirectory.addUniquePerson(karine);
        zAcademyDirectory.addUniquePerson(marina);

        System.out.println(zAcademyDirectory.getPersons());

        Optional<Person> personFound = zAcademyDirectory.searchPersonByName("Karine");
        if (personFound.isPresent()) {
            System.out.println(personFound.get());
        }

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

        zAcademyDirectory.getPromotions().add(javatar);
        zAcademyDirectory.getPromotions().add(javenturier);

        int searchedId = 8;
        try {
            zAcademyDirectory.searchPromotionById(searchedId);
        } catch (PromotionNotFoundException exception) {
            System.out.println("Impossible de trouver une promotion avec l'identifiant: " + searchedId);
        } catch (ArithmeticException exception) {
            System.out.println("Gros gogole on peut pas diviser par zero");
        } finally {
            System.out.println("Et des gros bsx au passage");
        }
    }
}