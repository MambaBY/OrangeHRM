package basetest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.basepage.BasePage;
import pages.loginpage.OrangeHrmLoginPage;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_CLOSED;

public class BaseTest {
    public BasePage basePage = new BasePage();
    public OrangeHrmLoginPage loginPage = new OrangeHrmLoginPage();

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
