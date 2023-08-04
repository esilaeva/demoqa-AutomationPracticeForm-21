package com.demoqa.tests;

import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class TextBoxPageObjectsTests extends TestBase {

    TextBoxPage textBox = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBox
                .openPage()
                .setUserName("Ilana Qa")
                .setUserEmail("ilana.qa@proton.me")
                .setCurrentAddress("Red Square 1")
                .setPermanentAddress("Another address")
                .clickSubmit();

        textBox
                .checkResultName("Ilana Qa")
                .checkResultEmail("ilana.qa@proton.me")
                .checkResultCurrentAddress("Red Square 1")
                .checkResultPermanentAddress("Another address");
    }
}
