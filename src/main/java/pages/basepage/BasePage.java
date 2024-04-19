package pages.basepage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static constants.Constants.Urls.LOGIN_PAGE;

public class BasePage {
    protected static final SelenideElement footer = $(".oxd-layout-footer");
    public void openLoginPage() {
        open(LOGIN_PAGE);
    }

    public void clickLeftSideMenuButton(SelenideElement menuSelector) {
        menuSelector.click();
        footer.shouldBe(Condition.visible);
    }
}



