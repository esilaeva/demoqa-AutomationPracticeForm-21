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
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setBirthDate(birthday[0], birthday[1], birthday[2])
                .setSubject(subject)
                .setHobbie(hobby)
                .uploadPicture(fileName)
                .setAddress(streetAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        tableResultComponent
                .checkResult(firstName + " " + lastName)
                .checkResult(userEmail)
                .checkResult(userGender)
                .checkResult(userNumber)
                .checkResult(birthday[0] + " " + birthday[1] + "," + birthday[2])
                .checkResult(subject)
                .checkResult(hobby)
                .checkResult(fileName)
                .checkResult(streetAddress)
                .checkResult(state + " " + city);
    }
}
