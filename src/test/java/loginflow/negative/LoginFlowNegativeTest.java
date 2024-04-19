package loginflow.negative;

import basetest.BaseTest;
import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


@Listeners({ScreenShooter.class})
public class LoginFlowNegativeTest extends BaseTest {
    @Test
    @Owner("spaulovich")
    @Step("Login page. Verify that Username and Password are required.")
    public void checkRequiredFields() throws IOException {
        basePage.openLoginPage();
        loginPage.clickLoginButton()
                .checkIfUsernameRequired()
                .checkIfPasswordRequired();
        takeScreenshot();

    }
    @Test
    @Owner("spaulovich")
    @Parameters({"invalidLogin", "invalidPassword"})
    @Step ("Login page. Verify validation error after submitting invalid credentials")
    public void insertInvalidCredentials(String invalidLogin, String invalidPassword) throws IOException {
        basePage.openLoginPage();
        loginPage.enterUserLogin(invalidLogin)
                 .enterUserPassword(invalidPassword)
                 .clickLoginButton()
                 .checkInvalidCredentialsAlert();
        takeScreenshot();
    }

}
