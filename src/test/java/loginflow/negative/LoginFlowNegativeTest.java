package loginflow.negative;

import basetest.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginFlowNegativeTest extends BaseTest {
    @Test
    @Parameters({"invalidLogin", "invalidPassword"})
    public void loginFlowNegative(String invalidLogin, String invalidPassword) {
        basePage.openLoginPage();
        loginPage.clickLoginButton()
                 .checkIfUsernameRequired()
                 .checkIfPasswordRequired()
                 .enterInvalidUserLogin(invalidLogin)
                 .enterInvalidUserPassword(invalidPassword)
                 .clickLoginButton()
                 .checkInavalidCredentialsAlert();

    }



}
