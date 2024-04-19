package loginflow.positive;

import basetest.BaseTest;
import com.codeborne.selenide.testng.ScreenShooter;
import common.Cookie;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static constants.Constants.UserCredentials.VALID_LOGIN;
import static constants.Constants.UserCredentials.VALID_PASSWORD;


@Listeners({ScreenShooter.class})
public class LoginFlowPositiveTest extends BaseTest {

    @Test
    @Owner("spaulovich")
    @Step("Verify that the user is logged in successfully")
    public void loginFlowPositive() throws IOException {
        basePage.openLoginPage();
        loginPage.enterUserLogin(VALID_LOGIN)
                .enterUserPassword(VALID_PASSWORD)
                .clickLoginButton();
        dashboardPage.checkDashboardPageUrlAddress()
                .checkPageTitle()
                .checkUserDropdown();

        takeScreenshot();
    }
    @AfterMethod
    public void getCookie(){
        Cookie.getAuthorizationCookieValue();
    }
}
