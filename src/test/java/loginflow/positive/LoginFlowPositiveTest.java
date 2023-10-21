package loginflow.positive;

import basetest.BaseTest;
import org.testng.annotations.Test;

public class LoginFlowPositiveTest extends BaseTest {
    @Test
    public void loginFlowPositive(){
        basePage.openLoginPage();
        loginPage.enterUserLogin()
                 .enterUserPassword()
                 .clickLoginButton();
        dashboardPage.checkUrl()
                     .checkPageTitle()
                     .checkUserDropdown();
    }

}
