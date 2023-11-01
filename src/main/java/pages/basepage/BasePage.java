package pages.basepage;
import static com.codeborne.selenide.Selenide.open;
import static constants.Constants.Urls.LOGIN_PAGE;

public class BasePage {
    public void openLoginPage() {
        open(LOGIN_PAGE);
    }

}
