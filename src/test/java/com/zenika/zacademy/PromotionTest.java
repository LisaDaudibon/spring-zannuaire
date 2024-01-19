package com.zenika.zacademy;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PromotionTest {

    private final Former karine = new Former("Karine", "Sabatier", "0701020304", "Rue de rennes", "karineagile4ever@yahoo.fr");
    private final Former xavier = new Former("Xavier", "Cassel", "0702020304", "Rue de nantes", "xavaxdu35@hotmail.fr");
    private final Student marina = new Student("Marina", "Assohoun", "0601020304", "Rue de dinan", "marinadu93@gmail.com");
    private final Student francis = new Student("Francis", "Rouxel", "0609020304", "Rue de paris", "franciiiiis@gmail.com");

    @Test
    void shouldDisplayCorrectlyMyPromotion() {
        Set<Former> javatarFormers = new HashSet<>();
        javatarFormers.add(karine);
        javatarFormers.add(xavier);

        Set<Student> javatarStudents = new HashSet<>();
        javatarStudents.add(marina);
        javatarStudents.add(francis);

        Promotion javatar = new Promotion(9, "javatar", LocalDate.of(2022, 12, 15), javatarFormers, javatarStudents);
        assertEquals("Promotion javatar N°9 a démarré le 15/12/2022\n" +
                "\n" +
                "\uD83D\uDC77 Formateurs:\n" +
                "\n" +
                "Formateur karine sabatier\n" +
                "\uD83D\uDCF1: 0701020304\n" +
                "\uD83D\uDCE7: karineagile4ever@yahoo.fr\n" +
                "\uD83C\uDFE0: Rue de rennes\n" +
                "\n" +
                "Formateur xavier cassel\n" +
                "\uD83D\uDCF1: 0702020304\n" +
                "\uD83D\uDCE7: xavaxdu35@hotmail.fr\n" +
                "\uD83C\uDFE0: Rue de nantes\n" +
                "\n" +
                "\n" +
                "\uD83E\uDDD1\u200D\uD83D\uDCBB Élèves:\n" +
                "\n" +
                "Élève marina assohoun\n" +
                "\uD83D\uDCF1: 0601020304\n" +
                "\uD83D\uDCE7: marinadu93@gmail.com\n" +
                "\uD83C\uDFE0: Rue de dinan\n" +
                "\n" +
                "Élève francis rouxel\n" +
                "\uD83D\uDCF1: 0609020304\n" +
                "\uD83D\uDCE7: franciiiiis@gmail.com\n" +
                "\uD83C\uDFE0: Rue de paris\n".trim(), javatar.toString().trim());
    }

    @Test
    void shouldNotAddStudentAfterInitialization() {
        Set<Former> javatarFormers = new HashSet<>();
        Set<Student> javatarStudents = new HashSet<>();
        Promotion javatar = new Promotion(9, "javatar", LocalDate.of(2022, 12, 15), javatarFormers, javatarStudents);
        assertEquals(0, javatar.getStudents().size());
        javatar.getStudents().add(marina);
        assertEquals(0, javatar.getStudents().size());
    }

    @Test
    void shouldNotAddFormerAfterInitialization() {
        Set<Former> javatarFormers = new HashSet<>();
        Set<Student> javatarStudents = new HashSet<>();
        Promotion javatar = new Promotion(9, "javatar", LocalDate.of(2022, 12, 15), javatarFormers, javatarStudents);
        assertEquals(0, javatar.getFormers().size());
        javatar.getFormers().add(karine);
        assertEquals(0, javatar.getFormers().size());
    }


}