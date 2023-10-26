package basetest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import pages.basepage.BasePage;
import pages.dashboard.DashboardPage;
import pages.loginpage.OrangeHrmLoginPage;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_CLOSED;

public class BaseTest {
    public BasePage basePage = new BasePage();
    public OrangeHrmLoginPage loginPage = new OrangeHrmLoginPage();
    public DashboardPage dashboardPage = new DashboardPage();


    @BeforeSuite
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }
    @AfterTest
    public void clearCookieAndLocalStorage () {
        if(CLEAR_COOKIES_AND_STORAGE){
            Selenide.clearBrowserCookies();
            Selenide.clearBrowserLocalStorage();
            Selenide.executeJavaScript("window.sessionStorage.clear()");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void close (){
        Configuration.holdBrowserOpen = HOLD_BROWSER_CLOSED;
    }



}
