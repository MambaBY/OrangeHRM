package pages.addempoyee;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.basepage.BasePage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static common.GenerateRandomUserNameAndUserID.generateRandomName;
import static common.GenerateRandomUserNameAndUserID.generateRandomUserID;
import static constants.Constants.Urls.ADD_EMPLOYEE_PAGE;

public class AddEmployeePage extends BasePage {

    public static String userID;
    public static String userFirstName;
    public static String userLastName;
    public final SelenideElement firstNameInput = $x("//input[@name='firstName']");
    public final SelenideElement lastNameInput = $x("//input[@name='lastName']");
    public final SelenideElement createLoginDetailsToggle = $x("//div[@class='oxd-switch-wrapper']");
    public final SelenideElement usernameInput =
            $x("(//div[@class='oxd-form-row'])[2]//input[@data-v-1f99f73c]");
    public final SelenideElement passwordInput = $x("(//input[@type = 'password'])[1]");
    public final SelenideElement confirmPasswordInput = $x("(//input[@type = 'password'])[2]");
    public final SelenideElement saveButton = $x("//button[@type='submit']");
    public final SelenideElement successConfirmationPopUp = $x("//div[@id='oxd-toaster_1']");
    public final SelenideElement employeeIdInput = $x("(//input[@data-v-1f99f73c])[5]");


    /*
     * Method is verifying that page URL is correct
     */
    public AddEmployeePage checkAddEmployeePageUrlAdress(){
        webdriver().shouldHave(url(ADD_EMPLOYEE_PAGE));
        return this;
    }

    /*
     * Method fills in First Name with random string value in the add employee form
     */
    public AddEmployeePage fillInFirstName () {
        userFirstName = generateRandomName(5);
        firstNameInput.setValue(userFirstName);
        return this;
    }

    /*
     * Method fills in Last Name with random string value in the add employee form
     */
    public AddEmployeePage fillInLastName() {
        userLastName = generateRandomName(8);
        lastNameInput.setValue(userLastName);
        return this;
    }

    /*
     * Method fills in user ID with random string value in the add employee form
     */
    public AddEmployeePage fillInEmployeeID() {
        employeeIdInput.sendKeys(Keys.CONTROL + "A");
        employeeIdInput.sendKeys(Keys.BACK_SPACE);
        userID = generateRandomUserID(8);
        employeeIdInput.setValue(userID);
        return this;
    }

    public AddEmployeePage clickLoginDetailsToggle() {
        createLoginDetailsToggle.click();
        return this;
    }

    /*
     * Method fills in username with random string value in the add employee form
     */
    public AddEmployeePage fillInUsername() {
        usernameInput.setValue(generateRandomName(8));
        return this;
    }

    /*
     * Method fills in password field with random string value in the add employee form
     */
    public AddEmployeePage fillInPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    /*
     * Method fills in password confirmation with random string value in the add employee form
     */
    public AddEmployeePage fillInPasswordConfirmation(String password) {
        confirmPasswordInput.setValue(password);
        return this;
    }

    public AddEmployeePage clickOnSaveButton() {
        saveButton.click();
        return this;
    }

    /*
     * Method is verifying that confirmation popup appears after a new user creation
     */
    public AddEmployeePage checkIfSuccessConfirmationPopUpAppears() {
        successConfirmationPopUp.shouldBe(Condition.visible);
        successConfirmationPopUp.shouldHave(Condition.text("Success\n" + "Successfully Saved"));
        return this;
    }
}
