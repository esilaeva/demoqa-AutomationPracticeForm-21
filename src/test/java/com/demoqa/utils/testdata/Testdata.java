package com.demoqa.utils.testdata;

import static com.demoqa.utils.RandomUtils.*;

public class Testdata {
    public static String
            firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            userEmail = getRandomEmail(),
            gender = getRandomGender(),
            userNumber = getRandomPhone(),
            date = getRandomDate(18, 99),
            year = getRandomYear(date),
            month = getRandomMonth(date),
            day = getRandomDay(date),
            birthday = day + " " + month + "," + year,
            subject = getRandomSubject(),
            hobby = getRandomHobbies(),
            fileName = "pic.png",
            streetAddress = getRandomAddress(),
            state = getRandomState(),
            city = getRandomCity(state);
}
