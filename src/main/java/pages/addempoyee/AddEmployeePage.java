package pages.addempoyee;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.basepage.BasePage;
import pages.dashboard.DashboardPage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static constants.Constants.Urls.ADD_EMPLOYEE_PAGE;
import static constants.Constants.Urls.DASHBOARD_PAGE;

public class AddEmployeePage extends BasePage {
    public final SelenideElement firstNameInput = $x("//input[@name='firstName']");
    public final SelenideElement lastNameInput = $x("//input[@name='lastName']");
    public final SelenideElement createLoginDetailsToggle = $x("//div[@class='oxd-switch-wrapper']");
    public final SelenideElement usernameInput =
            $x("(//div[@class='oxd-form-row'])[2]//input[@data-v-1f99f73c]");
    public final SelenideElement passwordInput = $x("(//input[@type = 'password'])[1]");
    public final SelenideElement confirmPasswordInput = $x("(//input[@type = 'password'])[2]");

    public AddEmployeePage checkAddEmployeePageUrlAdress(){
        webdriver().shouldHave(url(ADD_EMPLOYEE_PAGE));
        return this;
    }

    public AddEmployeePage fillInFirstName () {
        firstNameInput.setValue("John"); //TBD: value is set via a parameter
        return this;
    }

    public AddEmployeePage fillInLastName() {
      lastNameInput.setValue("Connor"); //TBD: value is set via a parameter
        return this;
    }

    public AddEmployeePage clickLoginDetailsToggle() {
        createLoginDetailsToggle.click();
        return this;
    }

    public AddEmployeePage fillInUsername() {
        usernameInput.setValue("jconnor"); //TBD: value is set via a parameter
        return this;
    }

    public AddEmployeePage fillInPassword() {
        passwordInput.setValue("Admin!741"); //TBD: value is set via a parameter
        return this;
    }

    public AddEmployeePage fillInPasswordConfirmation() {
        confirmPasswordInput.setValue("Admin!741"); //TBD: value is set via a parameter
        return this;
    }
}
