package endtoend.updatemyinfo;

import basetest.BaseTest;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import static common.LeftMenuButtons.myInfo;
import static constants.Constants.UserCredentials.VALID_LOGIN;
import static constants.Constants.UserCredentials.VALID_PASSWORD;
import static constants.Constants.UsersUpdatedPersonalInfo.NEW_FIRST_NAME;
import static constants.Constants.UsersUpdatedPersonalInfo.NEW_LAST_NAME;

public class UpdateMyInfoTest extends BaseTest {
    @Test
    @Owner("spaulovich")
    @Step("Update Personal Details on the My info page")
    public void updateMyInfo() throws Exception {
        basePage.openLoginPage();
        loginPage.enterUserLogin(VALID_LOGIN)
                .enterUserPassword(VALID_PASSWORD)
                .clickLoginButton();
        basePage.clickLeftSideMenuButton(myInfo);
        myInfoPage.checkTheTitle()
                .changeUserFirstName(NEW_FIRST_NAME)
                .changeUserLastName(NEW_LAST_NAME)
                .changeDriverLicenseNumber()
                .changeDriverLicenseExpiryDate()
                .changeNationality()
                .changeMaritalStatus()
                .saveMyInfoChanges()
                // TODO Actual value: hidden
                .checkIfSuccessConfirmationPopUpAppears();
        takeScreenshot();
    }
}
