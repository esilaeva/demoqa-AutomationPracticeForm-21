package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TableResultComponent {

    private SelenideElement
            resultTable = $(".table-responsive"),
            modalDialog = $(".modal-dialog");

    public TableResultComponent isModalDialogVisible() {
        modalDialog.should(appear);

        return this;
    }

    public TableResultComponent checkResult(String value) {
        resultTable.shouldHave(text(value));

        return this;
    }
}
