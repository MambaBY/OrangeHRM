package pages.myinfo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.basepage.BasePage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class MyInfoPage extends BasePage {
    public static final SelenideElement title = $x("//h6[text() = 'Personal Details']");
    public static final SelenideElement firstName = $x("//input[@name='firstName']");
    public static final SelenideElement lastName = $x("//input[@name='lastName']");
    public static final SelenideElement userNickName =
            $x("(//input[@class = 'oxd-input oxd-input--active'])[2]");
    public static final SelenideElement driverLicenseNumber =
            $x("(//input[@class = 'oxd-input oxd-input--active'])[5]");
    public static final SelenideElement driverLicenseExpiryDate =
            $x("(//input[@class = 'oxd-input oxd-input--active'])[6]");
    public static final SelenideElement nationalitySelector =
            $x("(//div[@class='oxd-select-text-input'])[1]");
    public static final SelenideElement maritalStatus =$x("(//div[@class='oxd-select-text-input'])[2]");

    public static final SelenideElement dateOfBirth =
            $x("(//input[@class = 'oxd-input oxd-input--active'])[9]");
    public static final SelenideElement isSmoker = $x("(//input[@type= 'checkbox'])[1]");
    public static final SelenideElement savePersonalDetailsButton = $x("(//button[@type='submit'])[1]");

    public MyInfoPage checkTheTitle() {
        title.shouldBe(Condition.visible);
        return this;
    }

    public MyInfoPage changeUserFirstName() {
        sleep(5000);
        firstName.sendKeys(Keys.CONTROL + "A");
        firstName.sendKeys(Keys.DELETE);
        firstName.setValue("Agent");
        return this;
    }
    public MyInfoPage changeUserLastName() {
        lastName.sendKeys(Keys.CONTROL + "A");
        lastName.sendKeys(Keys.DELETE);
        lastName.setValue("Smith");
        return this;
    }

    public MyInfoPage changeUserNickName() {
        userNickName.sendKeys(Keys.CONTROL + "A");
        userNickName.sendKeys(Keys.DELETE);
        userNickName.setValue("asmith");
        return this;
    }

}
