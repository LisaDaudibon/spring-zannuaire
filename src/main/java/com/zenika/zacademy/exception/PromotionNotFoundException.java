package com.zenika.zacademy.exception;

public class PromotionNotFoundException extends NotFoundException {

    public PromotionNotFoundException(String message) {
        super("Promotion", message);
    }
}
