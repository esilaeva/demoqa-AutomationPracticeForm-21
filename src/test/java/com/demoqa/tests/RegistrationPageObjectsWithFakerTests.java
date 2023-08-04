package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.components.TableResultComponent;
import org.junit.jupiter.api.Test;

import static com.demoqa.utils.testdata.Testdata.*;

public class RegistrationPageObjectsWithFakerTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TableResultComponent tableResult = new TableResultComponent();

    @Test
    void successRegistrationFullTest() {

        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDate(day, month, year)
                .setSubject(subject)
                .setHobbie(hobby)
                .uploadPicture(fileName)
                .setAddress(streetAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        tableResult
                .checkResult(firstName + " " + lastName)
                .checkResult(userEmail)
                .checkResult(gender)
                .checkResult(userNumber)
                .checkResult(birthday)
                .checkResult(subject)
                .checkResult(hobby)
                .checkResult(fileName)
                .checkResult(streetAddress)
                .checkResult(state + " " + city);
    }

}
