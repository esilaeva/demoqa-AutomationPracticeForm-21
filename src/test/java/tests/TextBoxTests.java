package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase {

    @Test
    void fillFormTest() {
        open("/text-box");

        $("#userName").setValue("Ilana Qa");
        $("#userEmail").setValue("ilana.qa@proton.me");
        $("#currentAddress").setValue("Red Square 1");
        $("#permanentAddress").setValue("Another address");
        $("#submit").click();

        $("#output #name").shouldHave(text("Ilana Qa"));
        $("#output #email").shouldHave(text("ilana.qa@proton.me"));
        $("#output #currentAddress").shouldHave(text("Red Square 1"));
        $("#output #permanentAddress").shouldHave(text("Another address"));
    }
}
