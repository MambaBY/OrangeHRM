package pages.loginpage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPageElementsSelectors {
    protected static final SelenideElement loginInput = $(By.name("username"));
    protected static final SelenideElement passwordInput = $(By.name("password"));

    protected static final SelenideElement loginButton = $x("//button[@type='submit']");
    protected static final SelenideElement validationMessageUsernameRequired =
            $x("(//span[text() = 'Required'])[1]");
    protected static final SelenideElement validationMessagePasswordRequired =
            $x("(//span[text() = 'Required'])[2]");
    protected static final SelenideElement invalidCredentialsAlert = $x("//div[@role= 'alert']");
}
