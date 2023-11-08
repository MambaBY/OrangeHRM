package pages.basepage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static constants.Constants.Urls.LOGIN_PAGE;

public class BasePage {
    public void openLoginPage() {
        open(LOGIN_PAGE);
    }

    public void clickLeftSideMenuButton(SelenideElement menuSelector) {
        menuSelector.click();
    }
}



