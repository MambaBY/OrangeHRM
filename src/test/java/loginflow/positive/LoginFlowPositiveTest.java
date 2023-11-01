package loginflow.positive;

import basetest.BaseTest;
import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.Owner;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({ ScreenShooter.class})
public class LoginFlowPositiveTest extends BaseTest {

    @Test
    @Owner("spaulovich")
    public void loginFlowPositive()  {
        basePage.openLoginPage();
        loginPage.enterUserLogin()
                .enterUserPassword()
                .clickLoginButton();
        dashboardPage.checkUrl()
                .checkPageTitle()
                .checkUserDropdown();

    }
}
