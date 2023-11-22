package endtoend.updatemyinfo;

import basetest.BaseTest;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import java.io.IOException;

import static common.LeftMenuButtons.myInfo;

public class UpdateMyInfoTest extends BaseTest {
    @Test
    @Owner("spaulovich")
    @Step("Update Personal Details on the My info page")
    public void updateMyInfo() throws IOException {
        loginPage.logInWithCookies();
        basePage.clickLeftSideMenuButton(myInfo);
        myInfoPage.checkTheTitle();

        takeScreenshot();
    }
}
