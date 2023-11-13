package pages.pim;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.basepage.BasePage;

import static com.codeborne.selenide.Selenide.$x;


public class PimPage extends BasePage {
    private final SelenideElement addButton = $x("//button[text()=' Add ']");
    private final SelenideElement userIDSearchField =
            $x("//div/label[text()='Employee Id']/following::div[1]/input"); //ID field in the search box
    private final SelenideElement employeeNameSearchField =
            $x("(//input[@placeholder='Type for hints...'])[1]"); // Employee Name field in the search box
    private final SelenideElement searchButton = $x("//button[@type='submit']");
    private final SelenideElement recordsFoundCounter = $x("//div[@data-v-0dea79bd]/div");
    private final SelenideElement userSearchResultCard =
            $x(" //div[@class='oxd-table-card']");
   private final SelenideElement userIdCulomnInSearchResultTable =
            $x("//div[@class='oxd-table-card']//div[2]");
    private final SelenideElement userFirstNameCulomnInSearchResultTable =
            $x("//div[@class='oxd-table-card']//div[3]");
    private final SelenideElement userLastNameCulomnInSearchResultTable =
            $x("//div[@class='oxd-table-card']//div[4]");


    public PimPage checkIfAddButtonVisible() {
        addButton.shouldBe(Condition.visible);
        return this;
    }

    public PimPage clickAddButton() {
        addButton.click();
        return this;
    }

    public PimPage inputUserName(String userFirstName, String userLastName) {
        employeeNameSearchField.setValue(userFirstName + " " + userLastName);
        return this;
    }

    public PimPage inputUserID(String userID) {
       userIDSearchField.setValue(userID);
       return this;
    }

    public PimPage clickOnSearchButton() {
        searchButton.click();
        return this;
    }

    /*
     * Method checks if the count of users found is equal to 1
     */
    public PimPage checkSearchResult() {
        recordsFoundCounter.shouldBe(Condition.visible);
        recordsFoundCounter.shouldBe(Condition.text("(1) Record Found"));
        return this;
    }

    /*
     * Method checks if the user card is available in the users table and user's data is appropriate
     */
    public PimPage checkFoundUsersData(String userID, String userFirstName, String userLastName) {
        userSearchResultCard.shouldBe(Condition.visible);
        userIdCulomnInSearchResultTable.shouldBe(Condition.text(userID));
        userFirstNameCulomnInSearchResultTable.shouldBe(Condition.text(userFirstName));
        userLastNameCulomnInSearchResultTable.shouldBe(Condition.text(userLastName));
        return this;
    }
}
