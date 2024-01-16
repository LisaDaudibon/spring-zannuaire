package com.zenika.zacademy;

public abstract class Person {
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String address;
    public String email;

    public Person(String firstName, String lastName, String phoneNumber, String address, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }
}
