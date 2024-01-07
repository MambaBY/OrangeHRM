package endtoend.updatemyinfo;

import basetest.BaseTest;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import static common.LeftMenuButtons.myInfo;

public class UpdateMyInfoTest extends BaseTest {
    @Test
    @Owner("spaulovich")
    @Step("Update Personal Details on the My info page")
    public void updateMyInfo() throws Exception {
        basePage.openLoginPage();
        loginPage.enterUserLogin()
                .enterUserPassword()
                .clickLoginButton();
        basePage.clickLeftSideMenuButton(myInfo);
        myInfoPage.checkTheTitle()
                  .changeUserFirstName()
                  .changeUserLastName()
                  .changeUserNickName()
                  .changeDriverLicenseNumber()
                  .changeDriverLicenseExpiryDate()
                  .changeNationality()
                  .changeMaritalStatus()
                  .changeSmokerStatus()
                  .saveMyInfoChanges()
                  .checkIfSuccessConfirmationPopUpAppears();
        takeScreenshot();
    }
}
