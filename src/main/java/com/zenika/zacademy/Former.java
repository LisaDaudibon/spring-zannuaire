package com.zenika.zacademy;

public class Former extends Person {

    public Former(String firstName, String lastName, String phoneNumber, String address, String email) {
        super(firstName, lastName, phoneNumber, address, email);
    }

    @Override
    public String toString() {
        return String.format("""
                Formateur %s %s
                📱: %s
                📧: %s
                🏠: %s
                """, this.firstName, this.lastName, this.phoneNumber, this.email, this.address);
    }
}
