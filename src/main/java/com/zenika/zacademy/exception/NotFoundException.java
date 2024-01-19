package com.zenika.zacademy.exception;

public class NotFoundException extends Exception {
    public String className;

    public NotFoundException(String className, String message) {
        super(String.format("No data found for class %s and search value: %s", className, message));
        this.className = className;
    }
}
