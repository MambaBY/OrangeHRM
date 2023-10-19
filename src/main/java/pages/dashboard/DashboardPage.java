package pages.dashboard;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.*;

public class DashboardPage {

    public final SelenideElement pageTitle = $x("//span[@class='oxd-topbar-header-breadcrumb']");


    public DashboardPage checkUrl(){
        webdriver().shouldHave(url("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));
        return this;
    }

    public DashboardPage checkPageTitle(){
       pageTitle.shouldBe(Condition.visible);
       pageTitle.shouldHave(Condition.exactText("Dashboard"));
       return this;
    }


}
