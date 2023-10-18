package pages.loginpage;

import com.codeborne.selenide.SelenideElement;
import pages.basepage.BasePage;

import static com.codeborne.selenide.Selenide.$x;
import static constants.Constants.UserCredentials.LOGIN;
import static constants.Constants.UserCredentials.PASSWORD;

public class OrangeHrmLoginPage extends BasePage {

    private final SelenideElement loginInput = $x("//input[@name='username']");
    private final SelenideElement passwordInput = $x("//input[@name='password']");
    private final SelenideElement loginButton = $x("//button[@type='submit']");

    public OrangeHrmLoginPage enterUserCredentials() {
        loginInput.setValue(LOGIN);
        passwordInput.setValue(PASSWORD);
        return this;
    }

    public OrangeHrmLoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }



}
