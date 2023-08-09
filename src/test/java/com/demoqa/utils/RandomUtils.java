package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static final String SPACE = " ";

    enum Month {
        Jan("January"), Feb("February"), Mar("March"), Apr("April"),
        May("May"), Jun("June"), Jul("July"), Aug("August"),
        Sep("September"), Oct("October"), Nov("November"), Dec("December");

        private final String fullName;

        Month(String fullName) {
            this.fullName = fullName;
        }
        public String getFullName() {
            return fullName;
        }
    }

    public static void main(String[] args) {

    }

    public static String getRandomString(int len) {
        //String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        return sb.toString();
    }

    public static String getRandomFirstName() {
        return new Faker(Locale.ENGLISH).name().firstName();
    }

    public static String getRandomLastName() {
        return new Faker(Locale.ENGLISH).name().lastName();
    }

    public static String getRandomEmail() {
        return String.format("%s@%s.%s", getRandomString(10), getRandomString(5), getRandomString(3));
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }

    public static String getRandomItemFromArray(String[] arr) {
        int index = getRandomInt(0, arr.length - 1);

        return arr[index];
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomPhone() {
//        return String.format("+%s (%s) %s - %s - %s", getRandomInt(1, 9), getRandomInt(111, 999),
//                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
        return String.format("%s%s%s%s", getRandomInt(111, 999), getRandomInt(111, 999),
                getRandomInt(11, 99), getRandomInt(11, 99));
    }

    public static String getRandomDay(String date) {
        String[] arr = date.split(SPACE);

        return arr[2];
    }

    public static String getRandomMonth(String date) {
        String[] arr = date.split(SPACE);

        return Month.valueOf(arr[1]).getFullName();
    }

    public static String getRandomYear(String date) {
        String[] arr = date.split(SPACE);

        return arr[5];
    }

    public static String getRandomDate(int minAge, int maxAge) {
        return new Faker().date().birthday(minAge, maxAge).toString();
    }

    public static String getRandomSubject() {
        String[] arr = {"English", "Chemistry", "Computer Science"
                , "Commerce", "Economics", "Social Studies"};

        return getRandomItemFromArray(arr);
    }

    public static String getRandomHobbies() {
        String[] arr = {"Sports", "Reading", "Music"};

        return getRandomItemFromArray(arr);
    }

    public static String getRandomAddress() {
        return new Faker().address().streetAddress();
    }

    public static String getRandomState() {
        String[] arr = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return getRandomItemFromArray(arr);
    }

    public static String getRandomCity(String state) {
        if (state.equals("NCR")) {
            String[] arr = {"Delhi", "Gurgaon", "Noida"};

            return new Faker().options().option(arr);
        } else if (state.equals("Uttar Pradesh")) {
            String[] arr = {"Agra", "Lucknow", "Merrut"};

            return new Faker().options().option(arr);
        } else if (state.equals("Haryana")) {
            String[] arr = {"Karnal", "Panipat"};

            return new Faker().options().option(arr);
        } else {
            String[] arr = {"Jaipur", "Jaiselmer"};

            return new Faker().options().option(arr);
        }

    }


}
