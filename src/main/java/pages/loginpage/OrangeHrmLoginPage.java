package pages.loginpage;

import com.codeborne.selenide.SelenideElement;
import pages.basepage.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    private final SelenideElement loginInput = $x("//input[@name='username']");
    private final SelenideElement passwordInput = $x("//input[@name='password']");
    private final SelenideElement loginButton = $x("//button[@type='submit']']");

    public 


}
