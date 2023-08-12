package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();

    private SelenideElement
            userFirstName = $("#firstName"),
            userLastName = $("#lastName"),
            userEmail = $("#userEmail"),
            userGender = $("#genterWrapper"),
            userMobile = $("#userNumber"),
            userBirthDate = $("#dateOfBirthInput"),
            subject = $("#subjectsInput"),
            hobby = $("#hobbiesWrapper"),
            userPicture = $("#uploadPicture"),
            userAddress = $("[placeholder='Current Address']"),
            state = $("#state"),
            stateCity = $("#stateCity-wrapper"),
            city = $("#city"),
            submitButton = $("#submit"),
            nameRegistrationForm = $(".practice-form-wrapper");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        nameRegistrationForm.shouldHave(text("Student Registration Form"));
        deleteBanners();
        return this;
    }

    public void deleteBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public RegistrationPage setFirstName(String value) {
        userFirstName.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        userLastName.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmail.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        userGender.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userMobile.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        userBirthDate.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subject.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbie(String value) {
        hobby.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        userPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        userAddress.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        state.click();
        stateCity.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        stateCity.$(byText(value)).click();

        return this;
    }

    public void clickSubmit() {
        submitButton.click();
    }
}
