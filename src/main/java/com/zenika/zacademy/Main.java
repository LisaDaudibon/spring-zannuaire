package com.zenika.zacademy;

import java.util.Optional;

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
    }
}