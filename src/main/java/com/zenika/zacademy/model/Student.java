package com.zenika.zacademy.model;

public class Student extends Person {

    public Student(String firstName, String lastName, String phoneNumber, String address, String email) {
        super(firstName, lastName, phoneNumber, address, email);
    }

    @Override
    public String toString() {
        return String.format("""
                Élève %s %s
                📱: %s
                📧: %s
                🏠: %s
                """, this.firstName, this.lastName, this.phoneNumber, this.email, this.address);
    }
}
