package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.TableResultComponent;

public class RegistrationPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TableResultComponent tableResult = new TableResultComponent();

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
            .uploadPicture("img/pic.png")
            .setAddress("Red Square 1")
            .setState("NCR")
            .setCity("Delhi")
            .clickSubmit();

        tableResult
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

        tableResult
            .isModalDialogVisible()
            .checkResultTitle("Thanks for submitting the form")
            .checkResult("Ilana Qa")
            .checkResult("Female")
            .checkResult("1234567890");
    }
}
