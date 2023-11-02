package pages.dashboard;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.*;

public class DashboardPage {

    public final SelenideElement pageTitle = $x("//span[@class='oxd-topbar-header-breadcrumb']");
    public final SelenideElement userDropdown = $x("//li[@class='oxd-userdropdown']");


    /*
     * Method is verifying page URL
     */
    public DashboardPage checkPageUrlAdress(){
        webdriver().shouldHave(url("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));
        return this;
    }


    /*
     * Method is verifying page title
     */
    public DashboardPage checkPageTitle(){
       pageTitle.shouldBe(Condition.visible);
       pageTitle.shouldHave(Condition.exactText("Dashboard"));
       return this;
    }

    /*
     * Method is verifying that user label with dropdown is visible on the Dashboard page after user logged in
     */
    public DashboardPage checkUserDropdown(){
        userDropdown.shouldBe(Condition.visible);
        return this;
    }


}
