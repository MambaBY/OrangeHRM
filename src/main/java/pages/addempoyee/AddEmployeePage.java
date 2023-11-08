package pages.addempoyee;

import com.codeborne.selenide.SelenideElement;
import pages.basepage.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class AddEmployeePage extends BasePage {
    public final SelenideElement firstNameInput = $x("//input[@name='firstName']");
    public final SelenideElement lastNameInput = $x("//input[@name='lastName']");
    public final SelenideElement createLoginDetailsToggle = $x("//div[@class='oxd-switch-wrapper']");
    public final SelenideElement usernameInput =
            $x("(//div[@class='oxd-form-row'])[2]//input[@data-v-1f99f73c]");
    public final SelenideElement passwordInput = $x("//input[@type = 'password']");



    public AddEmployeePage fillInFirstName () {
        firstNameInput.setValue("John"); //TBD: name is set via a parameter
        return this;
    }

    public AddEmployeePage fillInLastName() {
      lastNameInput.setValue("Connor"); //TBD: name is set via a parameter
        return this;
    }

    public AddEmployeePage clickLoginDetailsToggle() {
        createLoginDetailsToggle.click();
        return this;
    }

    public AddEmployeePage fillInUsername() {
        usernameInput.setValue("jconnor"); //TBD: name is set via a parameter
        return this;
    }
}
