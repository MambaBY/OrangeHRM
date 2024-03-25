package pages.pim;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PimPageElementsSelectors {
    protected static final SelenideElement addButton = $("i.bi-plus");
    //ID field in the search box
    protected static final SelenideElement userIDSearchField = $(".oxd-input-group input.oxd-input");

    protected static final SelenideElement employeeNameSearchField =
            $x("(//input[@placeholder='Type for hints...'])[1]"); // Employee Name field in the search box
    protected static final SelenideElement searchButton = $x("//button[@type='submit']");
    protected static final SelenideElement recordsFoundCounter = $(".orangehrm-horizontal-padding span");

    protected static final SelenideElement userSearchResultCard = $(".oxd-table-card");
    protected static final SelenideElement userIdColumnInSearchResultTable =
            $x("(//div[@role='cell'])[2]");
    protected static final SelenideElement userFirstNameColumnInSearchResultTable =
            $x("(//div[@role='cell'])[3]");
    protected static final SelenideElement userLastNameColumnInSearchResultTable =
            $x("(//div[@role='cell'])[4]");
}
