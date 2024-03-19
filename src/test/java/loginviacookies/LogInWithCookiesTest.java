package loginviacookies;

import basetest.BaseTest;
import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners({ ScreenShooter.class})
public class LogInWithCookiesTest extends BaseTest {
    @Test
    @Owner("spaulovich")
    @Step("Login to the app by setting the appropriate cookies.")
    public void logInWithCookiesTest() throws IOException {
        loginPage.logInWithCookies();
        dashboardPage.checkDashboardPageUrlAddress()
                     .checkPageTitle()
                     .checkUserDropdown();
        takeScreenshot();
    }

}
