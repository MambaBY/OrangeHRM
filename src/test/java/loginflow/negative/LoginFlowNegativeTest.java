package loginflow.negative;

import basetest.BaseTest;
import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.Owner;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


@Listeners({ ScreenShooter.class})
public class LoginFlowNegativeTest extends BaseTest {
    @Test
    @Owner("spaulovich")
    public void checkRequiredFields() {
        basePage.openLoginPage();
        loginPage.clickLoginButton()
                .checkIfUsernameRequired()
                .checkIfPasswordRequired();

    }
    @Test
    @Owner("spaulovich")
    @Parameters({"invalidLogin", "invalidPassword"})
    public void insertInvalidCredentials(String invalidLogin, String invalidPassword)  {
        loginPage.enterInvalidUserLogin(invalidLogin)
                 .enterInvalidUserPassword(invalidPassword)
                 .clickLoginButton()
                 .checkInavalidCredentialsAlert();

    }



}
