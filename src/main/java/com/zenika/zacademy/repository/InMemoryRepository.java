package com.zenika.zacademy.repository;

import com.zenika.zacademy.model.Directory;
import com.zenika.zacademy.model.Former;
import com.zenika.zacademy.model.Promotion;
import com.zenika.zacademy.model.Student;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class InMemoryRepository {

    private Directory academyDirectory = new Directory();

    public InMemoryRepository() {
        initData();
    }

    public Directory getAcademyDirectory() {
        return academyDirectory;
    }

    void initData() {
        // Création des données personnes
        Student marina = new Student("Marina", "Assohoun", "0601020304", "Rue de dinan", "marinadu93@gmail.com");
        Former karine = new Former("Karine", "Sabatier", "0701020304", "Rue de rennes", "karineagile4ever@yahoo.fr");
        Student yassir = new Student("Yassir", "LastName", "0709087098", "rue de londres", "yassiroklm@gmail.com");

        // Ajout des personnes à l'annuaire
        academyDirectory.addUniquePerson(karine);
        academyDirectory.addUniquePerson(marina);
        academyDirectory.addUniquePerson(yassir);

        // Création des promotions
        Set<Former> javatarFormers = new HashSet<>();
        javatarFormers.add(karine);

        Set<Student> javatarStudents = new HashSet<>();
        javatarStudents.add(marina);

        // new Date() => date à l'instant t
        // LocalDate.now()
        // new Date(2023, 12, 22);

        Promotion javatar = new Promotion(9, "javatar", LocalDate.of(2023, 12, 22), javatarFormers, javatarStudents);

        Set<Former> javenturierFormers = new HashSet<>();
        javenturierFormers.add(karine);

        Set<Student> javenturierStudents = new HashSet<>();
        javenturierStudents.add(yassir);

        Promotion javenturier = new Promotion(8, "javenturier", LocalDate.of(2022, 12, 15), javenturierFormers, javenturierStudents);

        // Ajout des promotions à l'annuaire
        academyDirectory.getPromotions().add(javatar);
        academyDirectory.getPromotions().add(javenturier);
    }
}
