package pages.myinfo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.basepage.BasePage;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static common.GenerateRandomUserNameAndUserID.generateRandomDriversLicenseNumber;

public class MyInfoPage extends BasePage {
    public static final SelenideElement title = $x("//h6[text() = 'Personal Details']");
    public static final SelenideElement firstName = $x("//input[@name='firstName']");
    public static final SelenideElement lastName = $x("//input[@name='lastName']");
    public static final SelenideElement userNickName =
            $x("//label[text() = 'Nickname']/following::input[1]");
    public static final SelenideElement driverLicenseNumber =
            $x("//label[text() = \"Driver's License Number\"]/following::input[1]");
    public static final SelenideElement driverLicenseExpiryDate =
            $x("//label[text() = 'License Expiry Date']/following::input[1]");
    public static final SelenideElement nationalitySelector =
            $x("//label[text()='Nationality']/following::div[1]");
    public static final SelenideElement nationalityOptions =
            $x("//div[@role='listbox']");
    public static final ElementsCollection listOfElementsInDorpDown = $$x("//div[@role='listbox']/div");
    public static final SelenideElement maritalStatus =$x("(//div[@class='oxd-select-text-input'])[2]");

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
        lastName.sendKeys(Keys.BACK_SPACE);
        lastName.setValue("Smith");
        return this;
    }

    public MyInfoPage changeUserNickName() {
        userNickName.sendKeys(Keys.CONTROL + "A");
        userNickName.sendKeys(Keys.BACK_SPACE);
        userNickName.setValue("asmith");
        return this;
    }

    public MyInfoPage changeDriverLicenseNumber() {
        driverLicenseNumber.sendKeys(Keys.CONTROL + "A");
        driverLicenseNumber.sendKeys(Keys.BACK_SPACE);
        driverLicenseNumber.setValue(generateRandomDriversLicenseNumber(8));
        return this;
    }

    public MyInfoPage changeDriverLicenseExpiryDate() throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 2);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String toDate = dateFormat.format(cal.getTime());
        driverLicenseExpiryDate.sendKeys(Keys.CONTROL + "A");
        driverLicenseExpiryDate.sendKeys(Keys.BACK_SPACE);
        driverLicenseExpiryDate.setValue(toDate);
        return this;
    }

    public String generateRandomOptionInList(ElementsCollection collection){
        List<String> options = new ArrayList();
        for (SelenideElement element : collection) {
            options.add(element.getText());
        }
        SecureRandom random = new SecureRandom();
        String newOption = options.get(random.nextInt(options.size()));
        return newOption;
    }

    public MyInfoPage changeNationality() {
        nationalitySelector.click();
        nationalityOptions.scrollTo();
        String newNationality = generateRandomOptionInList(listOfElementsInDorpDown);

        while (newNationality == nationalitySelector.getText()){
            newNationality = generateRandomOptionInList(listOfElementsInDorpDown);
        }
        $x("//div[@role='listbox']/div[@role='option']/span[(text() = '" + newNationality + "')]").click();
        nationalitySelector.shouldBe(Condition.exactText(newNationality));
        return this;
    }

    public MyInfoPage changeMaritalStatus() {
        maritalStatus.click();
        String newNMaritalStatus = generateRandomOptionInList(listOfElementsInDorpDown);

        while (newNMaritalStatus == nationalitySelector.getText()){
            newNMaritalStatus = generateRandomOptionInList(listOfElementsInDorpDown);
        }
        $x("//div[@role='listbox']/div[@role='option']/span[(text() = '" + newNMaritalStatus + "')]").click();
        maritalStatus.shouldBe(Condition.exactText(newNMaritalStatus));
        return this;
    }


}
