package com.zenika.zacademy;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Student marina = new Student("Marina", "Assohoun", "0601020304", "Rue de dinan", "marinadu93@gmail.com");
        Former karine = new Former("Karine", "Sabatier", "0701020304", "Rue de rennes", "karineagile4ever@yahoo.fr");
        Former karine2 = new Former("Karine", "Sabatier", "0701020304", "Rue de rennes", "karineagile4ever@yahoo.fr");

        Directory zAcademyDirectory = new Directory();
        zAcademyDirectory.addUnique(karine);
        zAcademyDirectory.addUnique(karine2);
        zAcademyDirectory.addUnique(marina);

        System.out.println(zAcademyDirectory.getPersons());

        Optional<Person> personFound = zAcademyDirectory.searchByName("Karine");
        if (personFound.isPresent()) {
            System.out.println(personFound.get());
        }

        Set<Person> javatarFormers = new HashSet<>();
        javatarFormers.add(karine);

        Set<Person> javatarStudents = new HashSet<>();
        javatarStudents.add(marina);

        Promotion javatar = new Promotion(9, "javatar", javatarFormers, javatarStudents);
        System.out.println(javatar);
    }
}