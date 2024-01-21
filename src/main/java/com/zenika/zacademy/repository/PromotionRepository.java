package com.zenika.zacademy.repository;

import com.zenika.zacademy.model.Promotion;

import java.util.Optional;
import java.util.Set;

public interface PromotionRepository {
    Set<Promotion> getPromotions();

    Optional<Promotion> findById(int promoNumber);
}
