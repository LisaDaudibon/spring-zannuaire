package com.zenika.zacademy;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Promotion {
    private final int id;
    private final String name;

    private final Set<Former> formers;
    private final Set<Student> students;

    public Promotion(int id, String name, Set<Former> formers, Set<Student> students) {
        this.id = id;
        this.name = name;
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
        return String.format("""
                        Promotion %s N°%s

                        👷 Formateurs:

                        %3$s

                        🧑‍💻 Élèves:

                        %4$s
                        """,
                this.name,
                this.id,
                this.getFormers().stream().map(Object::toString).collect(Collectors.joining("\n")),
                this.getStudents().stream().map(Object::toString).collect(Collectors.joining("\n"))
        );
    }
}
