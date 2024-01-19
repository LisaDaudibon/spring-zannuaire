package com.zenika.zacademy.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Promotion implements Comparable<Promotion> {
    private final int id;
    private final String name;
    private final LocalDate startDate;
    private final Set<Former> formers;
    private final Set<Student> students;

    public Promotion(int id, String name, LocalDate startDate, Set<Former> formers, Set<Student> students) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.formers = formers;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public Set<Former> getFormers() {
        // Permet de rendre immuable la liste des formateurs
        return new HashSet<>(formers);
    }

    public Set<Student> getStudents() {
        // Permet de rendre immuable la liste des élèves
        return new HashSet<>(students);
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("""
                        Promotion %s N°%s a démarré le %s

                        👷 Formateurs:

                        %s

                        🧑‍💻 Élèves:

                        %s
                        """,
                this.name,
                this.id,
                dateFormat.format(this.startDate),
                this.getFormers().stream().map(Object::toString).collect(Collectors.joining("\n")),
                this.getStudents().stream().map(Object::toString).collect(Collectors.joining("\n"))
        );
    }

    @Override
    public int compareTo(Promotion comparedPromotion) {
        return this.startDate.compareTo(comparedPromotion.startDate);
    }
}
