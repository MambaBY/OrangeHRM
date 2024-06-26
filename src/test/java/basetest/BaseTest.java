package basetest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.ScreenShooter;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import pages.addempoyee.AddEmployeePage;
import pages.basepage.BasePage;
import pages.buzzpage.BuzzNewsFeedPage;
import pages.dashboard.DashboardPage;
import pages.loginpage.OrangeHrmLoginPage;
import pages.myinfo.MyInfoPage;
import pages.pim.PimPage;

import java.io.File;
import java.io.IOException;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.IS_OPENED_FLAG;

@Listeners({ ScreenShooter.class})
public class BaseTest {

    public BasePage basePage = new BasePage();
    public OrangeHrmLoginPage loginPage = new OrangeHrmLoginPage();
    public DashboardPage dashboardPage = new DashboardPage();
    public PimPage pimPage = new PimPage();
    public AddEmployeePage addEmployeePage = new AddEmployeePage();
    public MyInfoPage myInfoPage = new MyInfoPage();
    public BuzzNewsFeedPage buzzNewsFeedPage = new BuzzNewsFeedPage();



    @BeforeSuite
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.screenshots = true; //if true -> screenshots are saved after the tests execution in build/reports
        Configuration.savePageSource = false;//if true-> page source is saved after the tests execution in build/reports
        Configuration.reportsFolder = "target/reports";
        ScreenShooter.captureSuccessfulTests = true; //if true-> screens are saved for green tests n build/reports
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }

    /**
    /* Method for saving screenshots in the Allure report
     */
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = ".png")
    public static byte[] takeScreenshot() throws IOException {
        File screenshot = Screenshots.takeScreenShotAsFile().getAbsoluteFile();
        return screenshot == null ? null : Files.toByteArray(screenshot);
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
        Configuration.holdBrowserOpen = IS_OPENED_FLAG;
    }
}
