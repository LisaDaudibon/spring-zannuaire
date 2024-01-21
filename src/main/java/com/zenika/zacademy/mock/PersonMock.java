package com.zenika.zacademy.mock;

import com.zenika.zacademy.model.Former;
import com.zenika.zacademy.model.Person;
import com.zenika.zacademy.model.Student;
import net.datafaker.Faker;
import net.datafaker.providers.base.Address;
import net.datafaker.providers.base.Internet;
import net.datafaker.providers.base.Name;
import net.datafaker.providers.base.PhoneNumber;

import java.util.Locale;

public class PersonMock {
    private static final Faker faker = new Faker(Locale.forLanguageTag("fr"));
    public static Person generateFakePerson() {
        boolean isAdmin = faker.bool().bool();
        Name name = faker.name();
        PhoneNumber phoneNumber = faker.phoneNumber();
        Address address = faker.address();
        Internet internet = faker.internet();
        return isAdmin ? new Former(name.firstName(), name.lastName(), phoneNumber.phoneNumber(), internet.emailAddress(), address.fullAddress()) : new Student(name.firstName(), name.lastName(), phoneNumber.phoneNumber(), internet.emailAddress(), address.fullAddress());
    }
}
