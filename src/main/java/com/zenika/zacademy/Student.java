package com.zenika.zacademy;

public class Student extends Person {
    public Student(String firstName, String lastName, String phoneNumber, String address, String email) {
        super(firstName, lastName, phoneNumber, address, email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
