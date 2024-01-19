package com.zenika.zacademy.exception;

public class PersonNotFoundException extends NotFoundException {
    public PersonNotFoundException(String message) {
        super("Person", message);
    }
}
