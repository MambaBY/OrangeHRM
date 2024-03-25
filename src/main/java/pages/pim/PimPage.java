package pages.pim;

import pages.basepage.BasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static constants.Constants.ValidationMassages.RECORDS_FOUND;
import static pages.pim.PimPageElementsSelectors.*;


public class PimPage extends BasePage {

    public PimPage checkIfAddButtonVisible() {
        addButton.shouldBe(visible);
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
        recordsFoundCounter.shouldBe(visible);
        recordsFoundCounter.shouldBe(text(RECORDS_FOUND));
        return this;
    }

    /*
     * Method checks if the user card is available in the users table and user's data is appropriate
     */
    public PimPage checkFoundUsersData(String userID, String userFirstName, String userLastName) {
        userSearchResultCard.shouldBe(visible);
        userIdColumnInSearchResultTable.shouldBe(text(userID));
        userFirstNameColumnInSearchResultTable.shouldBe(text(userFirstName));
        userLastNameColumnInSearchResultTable.shouldBe(text(userLastName));
        return this;
    }
}
