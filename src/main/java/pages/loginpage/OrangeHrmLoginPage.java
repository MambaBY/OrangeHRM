package pages.loginpage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.basepage.BasePage;

import static com.codeborne.selenide.Selenide.$x;
import static constants.Constants.UserCredentials.LOGIN;
import static constants.Constants.UserCredentials.PASSWORD;

public class OrangeHrmLoginPage extends BasePage {

    private final SelenideElement loginInput = $x("//input[@name='username']");
    private final SelenideElement passwordInput = $x("//input[@name='password']");
    private final SelenideElement loginButton = $x("//button[@type='submit']");
    private final SelenideElement validationMessageUsernameRequired =
            $x("(//span[text() = 'Required'])[1]");
    private final SelenideElement validationMessagePasswordRequired =
            $x("(//span[text() = 'Required'])[2]");
    private final SelenideElement invalidCredentialsAlert = $x("//div[@role= 'alert']");


    public OrangeHrmLoginPage enterUserLogin() {
        loginInput.setValue(LOGIN);
        return this;
    }


    public OrangeHrmLoginPage enterInvalidUserLogin(String invalidLogin) {
        loginInput.setValue(invalidLogin);
        return this;
    }

    public OrangeHrmLoginPage enterInvalidUserPassword(String invalidPassword) {
        passwordInput.setValue(invalidPassword);
        return this;
    }

    public OrangeHrmLoginPage enterUserPassword() {
        passwordInput.setValue(PASSWORD);
        return this;
    }

    public OrangeHrmLoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    public  OrangeHrmLoginPage checkIfUsernameRequired() {
        validationMessageUsernameRequired.shouldBe(Condition.visible);
        validationMessageUsernameRequired.shouldHave(Condition.exactText("Required"));
        return  this;
    }

    public  OrangeHrmLoginPage checkIfPasswordRequired() {
        validationMessagePasswordRequired.shouldBe(Condition.visible);
        validationMessagePasswordRequired.shouldHave(Condition.exactText("Required"));
        return  this;
    }

    public OrangeHrmLoginPage checkInavalidCredentialsAlert() {
        invalidCredentialsAlert.shouldBe(Condition.visible);
        invalidCredentialsAlert.shouldHave(Condition.exactText("Invalid credentials"));
        return this;
    }
}
