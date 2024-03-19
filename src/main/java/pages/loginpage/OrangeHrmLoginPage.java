package pages.loginpage;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import pages.basepage.BasePage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static common.Cookie.authorizationCookieName;
import static common.Cookie.authorizationCookieValue;
import static constants.Constants.ValidationMassages.INVALID_CREDENTIALS;
import static constants.Constants.ValidationMassages.REQUIRED;
import static pages.loginpage.LoginPageElementsSelectors.*;


public class OrangeHrmLoginPage extends BasePage {

    public OrangeHrmLoginPage enterUserLogin(String login) {
        loginInput.setValue(login);
        return this;
    }

    public OrangeHrmLoginPage enterUserPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    public OrangeHrmLoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    public  OrangeHrmLoginPage checkIfUsernameRequired() {
        validationMessageUsernameRequired.shouldBe(visible);
        validationMessageUsernameRequired.shouldHave(exactText(REQUIRED));
        return  this;
    }

    public  OrangeHrmLoginPage checkIfPasswordRequired() {
        validationMessagePasswordRequired.shouldBe(visible);
        validationMessagePasswordRequired.shouldHave(exactText(REQUIRED));
        return  this;
    }

    public OrangeHrmLoginPage checkInvalidCredentialsAlert() {
        invalidCredentialsAlert.shouldBe(visible);
        invalidCredentialsAlert.shouldHave(exactText(INVALID_CREDENTIALS));
        return this;
    }

    /*
     * Login to the app by setting the appropriate cookies.
     */
    public OrangeHrmLoginPage logInWithCookies() {
        openLoginPage();
        WebDriverRunner.getWebDriver().manage().deleteCookieNamed(authorizationCookieName);
        WebDriverRunner.getWebDriver().manage().addCookie(authorizationCookieValue);
        Selenide.refresh();
        return this;
    }
}
