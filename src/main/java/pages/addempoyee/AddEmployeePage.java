package pages.addempoyee;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Alert;
import pages.basepage.BasePage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static common.GenerateRandomUserName.generateRandomName;
import static constants.Constants.Urls.ADD_EMPLOYEE_PAGE;

public class AddEmployeePage extends BasePage {
    public final SelenideElement firstNameInput = $x("//input[@name='firstName']");
    public final SelenideElement lastNameInput = $x("//input[@name='lastName']");
    public final SelenideElement createLoginDetailsToggle = $x("//div[@class='oxd-switch-wrapper']");
    public final SelenideElement usernameInput =
            $x("(//div[@class='oxd-form-row'])[2]//input[@data-v-1f99f73c]");
    public final SelenideElement passwordInput = $x("(//input[@type = 'password'])[1]");
    public final SelenideElement confirmPasswordInput = $x("(//input[@type = 'password'])[2]");
    public final SelenideElement saveButton = $x("//button[@type='submit']");



    public AddEmployeePage checkAddEmployeePageUrlAdress(){
        webdriver().shouldHave(url(ADD_EMPLOYEE_PAGE));
        return this;
    }

    public AddEmployeePage fillInFirstName () {
        firstNameInput.setValue(generateRandomName(5));
        return this;
    }

    public AddEmployeePage fillInLastName() {
      lastNameInput.setValue(generateRandomName(8));
        return this;
    }

    public AddEmployeePage clickLoginDetailsToggle() {
        createLoginDetailsToggle.click();
        return this;
    }

    public AddEmployeePage fillInUsername() {
        usernameInput.setValue(generateRandomName(8));
        return this;
    }

    public AddEmployeePage fillInPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    public AddEmployeePage fillInPasswordConfirmation(String password) {
        confirmPasswordInput.setValue(password);
        return this;
    }

    public AddEmployeePage clickOnSaveButton() {
        saveButton.click();
        return this;
    }

}
