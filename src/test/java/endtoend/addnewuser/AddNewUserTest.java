package endtoend.addnewuser;

import basetest.BaseTest;
import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import static common.LeftMenuButtons.pimMenu;
import static constants.Constants.UserCredentials.VALID_LOGIN;
import static constants.Constants.UserCredentials.VALID_PASSWORD;
import static pages.addempoyee.AddEmployeePage.*;

@Listeners({ScreenShooter.class})
public class AddNewUserTest extends BaseTest {
    @Test
    @Owner("spaulovich")
    @Step("Add a new user to the system.")
    @Parameters({"password"})
    public void addNewUser(String password) throws IOException {
        basePage.openLoginPage();

        loginPage.enterUserLogin(VALID_LOGIN)
                .enterUserPassword(VALID_PASSWORD)
                .clickLoginButton();

        basePage.clickLeftSideMenuButton(pimMenu);

        pimPage.checkIfAddButtonVisible()
                .clickAddButton();

        addEmployeePage.checkAddEmployeePageUrlAddress()
                .fillInFirstName()
                .fillInLastName()
                .fillInEmployeeID()
                .clickLoginDetailsToggle()
                .fillInUsername()
                .fillInPassword(password)
                .fillInPasswordConfirmation(password)
                .clickOnSaveButton()
                // TODO Next line invoked an error:
                // Element should be visible {#oxd-toaster_1}
                // Element: '<div class="oxd-toast-container oxd-toast-container--bottom" id="oxd-toaster_1" displayed:false></div>'
                // Actual value: hidden
                .checkIfSuccessConfirmationPopUpAppears();

        takeScreenshot();
    }

    @Test
    @Owner("spaulovich")
    @Step("Verify that a new user is available in the list of users")
    public void checkUserInTheList() throws IOException {
        basePage.clickLeftSideMenuButton(pimMenu);
        pimPage.inputUserName(userFirstName, userLastName)
                .inputUserID(userID)
                .clickOnSearchButton()
                // TODO Next line invoked an error:
                // Element should be text "(1) Record Found" {.orangehrm-horizontal-padding span}
                // Element: '<span class="oxd-text oxd-text--span" data-v-7b563373 data-v-f5806396>No Records Found</span>'
                // Actual value: text="No Records Found"
                .checkSearchResult()
                .checkFoundUsersData(userID, userFirstName, userLastName);
        takeScreenshot();
    }
}
