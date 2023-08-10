package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static final String SPACE = " ";

    private static final Map<String, String> monthMap = new HashMap<>();

    static {
        monthMap.put("Jan", "January");
        monthMap.put("Feb", "February");
        monthMap.put("Mar", "March");
        monthMap.put("Apr", "April");
        monthMap.put("May", "May");
        monthMap.put("Jun", "June");
        monthMap.put("Jul", "July");
        monthMap.put("Aug", "August");
        monthMap.put("Sep", "September");
        monthMap.put("Oct", "October");
        monthMap.put("Nov", "November");
        monthMap.put("Dec", "December");
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

        return monthMap.get(date.split(SPACE)[1]);
    }

    public static String getRandomYear(String date) {

        return date.split(SPACE)[5];
    }

    public static String getRandomDate(int minAge, int maxAge) {
        return new Faker().date().birthday(minAge, maxAge).toString();
    }

    public static String getRandomSubject() {
        String[] subject = {"English", "Chemistry", "Computer Science"
                , "Commerce", "Economics", "Social Studies"};

        return getRandomItemFromArray(subject);
    }

    public static String getRandomHobbies() {
        String[] hobby = {"Sports", "Reading", "Music"};

        return getRandomItemFromArray(hobby);
    }

    public static String getRandomAddress() {
        return new Faker().address().streetAddress();
    }

    public static String getRandomState() {
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return getRandomItemFromArray(state);
    }

    public static String getRandomCity(String state) {

        if (state.equals("NCR")) {
            String[] cityNCR = {"Delhi", "Gurgaon", "Noida"};

            return new Faker().options().option(cityNCR);
        } else if (state.equals("Uttar Pradesh")) {
            String[] cityUP = {"Agra", "Lucknow", "Merrut"};

            return new Faker().options().option(cityUP);
        } else if (state.equals("Haryana")) {
            String[] cityH = {"Karnal", "Panipat"};

            return new Faker().options().option(cityH);
        } else {
            String[] cityR = {"Jaipur", "Jaiselmer"};

            return new Faker().options().option(cityR);
        }

    }


}
