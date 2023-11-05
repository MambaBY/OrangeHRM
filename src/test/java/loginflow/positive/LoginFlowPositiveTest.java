package loginflow.positive;

import basetest.BaseTest;
import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;


@Listeners({ ScreenShooter.class})
public class LoginFlowPositiveTest extends BaseTest {

    @Test
    @Owner("spaulovich")
    @Step("Verify that the user is logged in successfully")
    public void loginFlowPositive() throws IOException {
        basePage.openLoginPage();
        loginPage.enterUserLogin()
                .enterUserPassword()
                .clickLoginButton();
        dashboardPage.checkPageUrlAdress()
                .checkPageTitle()
                .checkUserDropdown();
        takeScreenshot();
    }
}
