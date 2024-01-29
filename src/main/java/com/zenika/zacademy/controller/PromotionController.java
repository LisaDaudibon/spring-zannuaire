package com.zenika.zacademy.controller;

import com.zenika.zacademy.exception.PromotionNotFoundException;
import com.zenika.zacademy.model.Promotion;
import com.zenika.zacademy.service.PromotionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/promotions")
public class PromotionController {
    private final PromotionService promotionService;
    public PromotionController(PromotionService promotionService) {this.promotionService = promotionService; }
    @GetMapping
    List<Promotion> findAll() {
        return this.promotionService.findAll();
    }

    @GetMapping("/{id}")
    Promotion
    findById(@PathVariable("id") int id) {
        try {
            return this.promotionService.findById(id);
        } catch (PromotionNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Error while searching Promotion with id %s", id));
        }
    }
}
