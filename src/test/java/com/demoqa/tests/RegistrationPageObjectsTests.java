package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.components.TableResultComponent;
import org.junit.jupiter.api.Test;

public class RegistrationPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TableResultComponent tableResultComponent = new TableResultComponent();

    @Test
    void successRegistrationFullTest() {
        registrationPage
                .openPage()
                .setFirstName("Ilana")
                .setLastName("Qa")
                .setUserEmail("ilana.qa@proton.me")
                .setGender("Female")
                .setUserNumber("1234567890")
                .setBirthDate("09", "April", "2020")
                .setSubject("English")
                .setHobbie("Sports")
                .uploadPicture("pic.png")
                .setAddress("Red Square 1")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit();

        tableResultComponent
                .checkResult("Ilana Qa")
                .checkResult("ilana.qa@proton.me")
                .checkResult("Female")
                .checkResult("1234567890")
                .checkResult("09 April,2020")
                .checkResult("English")
                .checkResult("Sports")
                .checkResult("pic.png")
                .checkResult("Red Square 1")
                .checkResult("NCR Delhi");
    }

    @Test
    void successRegistrationMinimalTest() {

        registrationPage
                .openPage()
                .setFirstName("Ilana")
                .setLastName("Qa")
                .setGender("Female")
                .setUserNumber("1234567890")
                .clickSubmit();

        tableResultComponent
                .isModalDialogVisible()
                .checkResultTitle("Thanks for submitting the form")
                .checkResult("Ilana Qa")
                .checkResult("Female")
                .checkResult("1234567890");
    }
}
