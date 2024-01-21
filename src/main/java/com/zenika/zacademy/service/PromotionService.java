package com.zenika.zacademy.service;

import com.zenika.zacademy.exception.PromotionNotFoundException;
import com.zenika.zacademy.model.Promotion;
import com.zenika.zacademy.repository.PromotionRepository;

import java.util.ArrayList;
import java.util.Collections;

public class PromotionService {

    private final PromotionRepository repository;

    public PromotionService(PromotionRepository repository) {
        this.repository = repository;
    }

    public ArrayList<Promotion> findAll() {
        ArrayList<Promotion> promotionsList = new ArrayList<>(repository.getPromotions());
        Collections.sort(promotionsList);
        return promotionsList;
    }

    public Promotion findById(int searchId) throws PromotionNotFoundException {
        return repository.findById(searchId).orElseThrow(() -> new PromotionNotFoundException("search by id " + searchId));
    }
}
