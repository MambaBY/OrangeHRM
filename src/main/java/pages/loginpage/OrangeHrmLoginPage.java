package pages.loginpage;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import pages.basepage.BasePage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static common.Cookie.authorizationCookieName;
import static common.Cookie.authorizationCookieValue;
import static constants.Constants.UserCredentials.LOGIN;
import static constants.Constants.UserCredentials.PASSWORD;
import static pages.loginpage.LoginPageElementsSelectors.*;


public class OrangeHrmLoginPage extends BasePage {

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
        validationMessageUsernameRequired.shouldBe(visible);
        validationMessageUsernameRequired.shouldHave(exactText("Required"));
        return  this;
    }

    public  OrangeHrmLoginPage checkIfPasswordRequired() {
        validationMessagePasswordRequired.shouldBe(visible);
        validationMessagePasswordRequired.shouldHave(exactText("Required"));
        return  this;
    }

    public OrangeHrmLoginPage checkInvalidCredentialsAlert() {
        invalidCredentialsAlert.shouldBe(visible);
        invalidCredentialsAlert.shouldHave(exactText("Invalid credentials"));
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
