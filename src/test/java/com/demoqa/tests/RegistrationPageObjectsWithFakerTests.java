package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.components.TableResultComponent;
import org.junit.jupiter.api.Test;

import static com.demoqa.utils.Testdata.*;

public class RegistrationPageObjectsWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TableResultComponent tableResultComponent = new TableResultComponent();

    @Test
    void successRegistrationFullTest() {
        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setMobileNumber(userNumber)
                .setBirthDate(birthDay, birthdayMonth, birthdayYear)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture(fileName)
                .setAddress(streetAddress)
                .setState(state)
                .setCity(city)
                .clickSubmitButton();

        tableResultComponent
                .checkResult(firstName + " " + lastName)
                .checkResult(userEmail)
                .checkResult(userGender)
                .checkResult(userNumber)
                .checkResult(birthDay + " " + birthdayMonth + "," + birthdayYear)
                .checkResult(subject)
                .checkResult(hobby)
                .checkResult(fileName)
                .checkResult(streetAddress)
                .checkResult(state + " " + city);
    }
}
