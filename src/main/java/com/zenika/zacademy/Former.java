package com.zenika.zacademy;

public class Former extends Person {

    public Former(String firstName, String lastName, String phoneNumber, String address, String email) {
        super(firstName, lastName, phoneNumber, address, email);
    }

    @Override
    public String toString() {
        return "Former{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
