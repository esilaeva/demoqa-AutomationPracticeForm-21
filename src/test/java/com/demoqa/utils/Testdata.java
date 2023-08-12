package com.demoqa.utils;

import static com.demoqa.utils.RandomUtils.*;

public class Testdata {
    public static String
            firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            userEmail = getRandomEmail(),
            userGender = getRandomGender(),
            userNumber = getRandomPhone(),
            subject = getRandomSubject(),
            hobby = getRandomHobbies(),
            fileName = "pic.png",
            streetAddress = getRandomAddress(),
            state = getRandomState(),
            city = getRandomCity(state);

    public static String[] birthday = getRandomDate(14, 99);
}
