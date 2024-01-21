package com.zenika.zacademy.repository;

import com.zenika.zacademy.model.Former;
import com.zenika.zacademy.model.Person;
import com.zenika.zacademy.model.Promotion;
import com.zenika.zacademy.model.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.zenika.zacademy.mock.PromotionMock.generateFakePromotion;

/**
 * Représente une base de données in memory pour la gestion des promotions
 * Quand le programme s'arrête, toutes les données générées sont supprimées
 */
public class InMemoryPromotionRepository implements PromotionRepository {

    private static final int NUMBER_OF_DATA = 10;
    // Représente ma base de données
    private final Set<Promotion> promotions = new HashSet<>();

    public InMemoryPromotionRepository(PersonRepository personRepository) {

        int numberOfPersonPerPromotion = personRepository.getDirectory().size() / 10;

        for (int i = 0; i < numberOfPersonPerPromotion; i++) {
            List<Person> subList = new ArrayList<>(personRepository.getDirectory()).subList(i * NUMBER_OF_DATA, i * NUMBER_OF_DATA + NUMBER_OF_DATA);
            Set<Student> students = subList.stream().filter(p -> p instanceof Student).map(Student.class::cast).collect(Collectors.toSet());
            Set<Former> formers = subList.stream().filter(p -> p instanceof Former).map(Former.class::cast).collect(Collectors.toSet());
            promotions.add(generateFakePromotion(students, formers));
        }
    }


    @Override
    public Set<Promotion> getPromotions() {
        return this.promotions;
    }

    @Override
    public Optional<Promotion> findById(int promoNumber) {
        return promotions.stream().filter(promotion -> promotion.getId() == promoNumber).findAny();
    }
}
