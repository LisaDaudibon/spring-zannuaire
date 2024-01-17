package com.zenika.zacademy;

public class Main {
    public static void main(String[] args) {
        Person marina = new Student("Marina", "Assohoun", "0601020304", "Rue de dinan", "marinadu93@gmail.com");
        Person karine = new Former("Karine", "Sabatier", "0701020304", "Rue de rennes", "karineagile4ever@yahoo.fr");
        Person karine2 = new Former("Karine", "Sabatier", "0701020304", "Rue de rennes", "karineagile4ever@yahoo.fr");

        System.out.println(marina);
        System.out.println(karine);

        Directory zAcademyDirectory = new Directory();
        zAcademyDirectory.addUnique(karine);
        zAcademyDirectory.addUnique(karine2);

        System.out.println(zAcademyDirectory.getPersons());
    }
}