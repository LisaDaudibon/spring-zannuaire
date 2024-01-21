package com.zenika.zacademy.mock;

import com.zenika.zacademy.model.Former;
import com.zenika.zacademy.model.Promotion;
import com.zenika.zacademy.model.Student;
import net.datafaker.Faker;

import java.util.Locale;
import java.util.Set;

public class PromotionMock {
    private static final Faker faker = new Faker(Locale.forLanguageTag("fr"));
    private static int promoConter = 1;

    public static Promotion generateFakePromotion(Set<Student> students, Set<Former> formers) {
        return new Promotion(promoConter++, faker.superhero().name(), faker.date().birthday().toLocalDateTime().toLocalDate(), formers, students);
    }
}
