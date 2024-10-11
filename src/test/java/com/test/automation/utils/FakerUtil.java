package com.test.automation.utils;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FakerUtil {

    static Faker faker = new Faker();
    protected static String Male;
    protected static String Active;

    public static String getNumber() {

        return String.valueOf(faker.number());
    }

    static String getEmail() {

        return String.valueOf(faker.name().firstName() + "@gmail.com");
    }

    public static String getFirstName() {
        return faker.name().firstName();
    }

    static String getLastName() {
        return faker.name().lastName();
    }

    public static String getGender() {
        return Male;
    }

    static String getFromDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Faker faker = new Faker();
        return sdf.format(faker.date().birthday());
    }

    static String getToDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Faker faker = new Faker();
        return sdf.format(faker.date().birthday());
    }

    static String getFood() {
        return faker.food().fruit();
    }

    static String getStatus() {
        return Active;
    }

    static Boolean getBooleanValueTrue() {
        return faker.bool().equals("true");
    }
}
