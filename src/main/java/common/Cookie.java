package common;

import com.codeborne.selenide.WebDriverRunner;


public class Cookie {
    public static final String authorizationCookieName = "orangehrm";
    public static org.openqa.selenium.Cookie authorizationCookieValue;

    public static void getAuthorizationCookieValue() {
        authorizationCookieValue = WebDriverRunner.getWebDriver().manage().getCookieNamed(authorizationCookieName);
    }
}
