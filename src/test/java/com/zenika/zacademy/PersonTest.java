package com.zenika.zacademy;

import com.zenika.zacademy.model.Former;
import com.zenika.zacademy.model.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

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

}