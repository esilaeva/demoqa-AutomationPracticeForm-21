package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    SelenideElement
            userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressTextArea = $("#currentAddress"),
            permanentAddressTextArea = $("#permanentAddress"),
            submitButton = $("#submit"),
            outputName = $("#output #name"),
            outputEmail = $("#output #email"),
            outputCurrentAddress = $("#output #currentAddress"),
            outputPermanentAddress = $("#output #permanentAddress");

    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public TextBoxPage setUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressTextArea.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressTextArea.setValue(value);

        return this;
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public TextBoxPage checkResultName(String value) {
        outputName.shouldHave(text(value));

        return this;
    }


    public TextBoxPage checkResultEmail(String value) {
        outputEmail.shouldHave(text(value));

        return this;
    }


    public TextBoxPage checkResultCurrentAddress(String value) {
        outputCurrentAddress.shouldHave(text(value));

        return this;
    }


    public TextBoxPage checkResultPermanentAddress(String value) {
        outputPermanentAddress.shouldHave(text(value));

        return this;
    }


}
