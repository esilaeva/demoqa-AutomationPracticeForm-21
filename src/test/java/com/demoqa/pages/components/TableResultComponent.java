package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TableResultComponent {
    SelenideElement
            tableResult = $(".table-responsive"),
            title = $("#example-modal-sizes-title-lg"),
            modalDialog = $(".modal-dialog");

    public TableResultComponent checkResultTitle(String value) {
        title.shouldHave(text(value));

        return this;
    }

    public TableResultComponent isModalDialogVisible() {
        modalDialog.should(appear);

        return this;
    }

    public TableResultComponent checkResult(String value) {
        tableResult.shouldHave(text(value));

        return this;
    }
}
