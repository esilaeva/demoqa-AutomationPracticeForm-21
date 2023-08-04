package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();
    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            birthDateInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbieInput = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            addressTextArea = $("[placeholder='Current Address']"),
            state = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            city = $("#city"),
            button = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        birthDateInput.click();
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        // $("#subjectsInput").setValue(value).pressEnter();
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbie(String value) {
        hobbieInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressTextArea.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        state.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public void clickSubmit() {
        button.click();
    }


}
