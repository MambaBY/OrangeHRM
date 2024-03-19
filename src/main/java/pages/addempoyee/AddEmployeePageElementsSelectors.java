package pages.addempoyee;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AddEmployeePageElementsSelectors {
    protected static final SelenideElement firstNameInput = $(By.name("firstName"));
    protected static final SelenideElement lastNameInput = $(By.name("lastName"));
    protected static final SelenideElement createLoginDetailsToggle = $(".oxd-switch-wrapper");
    protected static final SelenideElement usernameInput = $x("//label[text()='Username']/following::input[1]");
    protected static final SelenideElement passwordInput = $x("(//input[@type = 'password'])[1]");
    protected static final SelenideElement confirmPasswordInput = $x("(//input[@type = 'password'])[2]");
    protected static final SelenideElement saveButton = $x("//button[@type='submit']");
    protected static final SelenideElement successConfirmationPopUp = $(By.id("oxd-toaster_1"));
    protected static final SelenideElement employeeIdInput = $x("//label[text()='Employee Id']//following::input[1]");
}
