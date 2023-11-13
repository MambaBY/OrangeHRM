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

@Listeners({ ScreenShooter.class})
public class AddNewUserTest extends BaseTest {
    @Test
    @Owner("spaulovich")
    @Step("Add a new user to the system. End-to-end test")
    @Parameters({"password"})
    public void addNewUser(String password) throws IOException {
        loginPage.logInWithCookies();
        basePage.clickLeftSideMenuButton(pimMenu);
        pimPage.checkIfAddButtonVisible()
               .clickAddButton();
        addEmployeePage.checkAddEmployeePageUrlAdress()
                        .fillInFirstName()
                        .fillInLastName()
                        .clickLoginDetailsToggle()
                        .fillInUsername()
                        .fillInPassword(password)
                        .fillInPasswordConfirmation(password)
                        .clickOnSaveButton()
                        .checkIfSuccessConfirmationPopUpAppears();
        takeScreenshot();
    }
}
