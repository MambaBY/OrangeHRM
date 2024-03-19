package pages.dashboard;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static constants.Constants.Urls.DASHBOARD_PAGE;

public class DashboardPage {
    private final SelenideElement pageTitle = $x("//span[@class='oxd-topbar-header-breadcrumb']");
    private final SelenideElement userDropdown = $x("//li[@class='oxd-userdropdown']");

    /*
     * Method is verifying page URL
     */
    public DashboardPage checkDashboardPageUrlAddress(){
        webdriver().shouldHave(url(DASHBOARD_PAGE));
        return this;
    }

    /*
     * Method is verifying page title
     */
    public DashboardPage checkPageTitle(){
       pageTitle.shouldBe(visible);
       pageTitle.shouldHave(exactText("Dashboard"));
       return this;
    }

    /*
     * Method is verifying that user label with dropdown is visible on the Dashboard page after user logged in
     */
    public DashboardPage checkUserDropdown(){
        userDropdown.shouldBe(visible);
        return this;
    }
}
