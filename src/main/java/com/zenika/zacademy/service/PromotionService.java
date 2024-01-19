package com.zenika.zacademy.service;

import com.zenika.zacademy.exception.PromotionNotFoundException;
import com.zenika.zacademy.model.Promotion;
import com.zenika.zacademy.repository.InMemoryRepository;

import java.util.ArrayList;
import java.util.Collections;

public class PromotionService {

    private final InMemoryRepository repository;

    public PromotionService(InMemoryRepository repository) {
        this.repository = repository;
    }

    public ArrayList<Promotion> findAll() {
        ArrayList<Promotion> promotionsList = new ArrayList<>(repository.getAcademyDirectory().getPromotions());
        Collections.sort(promotionsList);
        return promotionsList;
    }

    public Promotion findById(int searchId) throws PromotionNotFoundException {
        return repository.getAcademyDirectory().searchPromotionById(searchId);
    }
}
