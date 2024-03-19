package pages.addempoyee;

import org.openqa.selenium.Keys;
import pages.basepage.BasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static common.GenerateRandomValues.generateRandomName;
import static common.GenerateRandomValues.generateRandomUserID;
import static constants.Constants.Urls.ADD_EMPLOYEE_PAGE;
import static pages.addempoyee.AddEmployeePageElementsSelectors.*;


public class AddEmployeePage extends BasePage {

    public static String userID;
    public static String userFirstName;
    public static String userLastName;


    /*
     * Method is verifying that page URL is correct
     */
    public AddEmployeePage checkAddEmployeePageUrlAddress(){
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
        successConfirmationPopUp.shouldBe(visible);
        successConfirmationPopUp.shouldHave(text("Success\n Successfully Saved"));
        return this;
    }
}
