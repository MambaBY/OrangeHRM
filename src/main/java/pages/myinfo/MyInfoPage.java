package pages.myinfo;

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

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static common.GenerateRandomValues.generateRandomDriversLicenseNumber;
import static pages.myinfo.MyInfoPageElementsSelectors.*;

public class MyInfoPage extends BasePage {

    public MyInfoPage checkTheTitle() {
        title.shouldBe(visible);
        return this;
    }

    public MyInfoPage changeUserFirstName(String firstNameUpdated) {
        sleep(5000);
        firstName.sendKeys(Keys.CONTROL + "A");
        firstName.sendKeys(Keys.DELETE);
        firstName.setValue(firstNameUpdated);
        return this;
    }
    public MyInfoPage changeUserLastName(String lastNameUpdated) {
        lastName.sendKeys(Keys.CONTROL + "A");
        lastName.sendKeys(Keys.BACK_SPACE);
        lastName.setValue(lastNameUpdated);
        return this;
    }


    public MyInfoPage changeDriverLicenseNumber() {
        driverLicenseNumber.sendKeys(Keys.CONTROL + "A");
        driverLicenseNumber.sendKeys(Keys.BACK_SPACE);
        driverLicenseNumber.setValue(generateRandomDriversLicenseNumber(8));
        return this;
    }

    public MyInfoPage changeDriverLicenseExpiryDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 2);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String toDate = dateFormat.format(cal.getTime());
        driverLicenseExpiryDate.sendKeys(Keys.CONTROL + "A");
        driverLicenseExpiryDate.sendKeys(Keys.BACK_SPACE);
        driverLicenseExpiryDate.setValue(toDate);
        driverLicenseExpiryDate.scrollIntoView(true);
        return this;
    }

    /*
     * Method that is selecting random value in the dropdown on the MyInfo page
     */
    public String generateRandomOptionInList(ElementsCollection collection){
        List<String> options = new ArrayList<>();
        for (SelenideElement element : collection) {
            options.add(element.getText());
        }
        SecureRandom random = new SecureRandom();
        return options.get(random.nextInt(options.size()));
    }

    public MyInfoPage changeNationality() {
        String currentNationality = listOfNationalities.getText();
        listOfNationalities.click();
        String newNationality = generateRandomOptionInList(listOfElementsInDorpDown);
        while (newNationality.equals(currentNationality) || newNationality.equals("-- Select --")){
            newNationality = generateRandomOptionInList(listOfElementsInDorpDown);
        }
        $x("//div[@role='listbox']/div[@role='option']/span[(text() = '" + newNationality + "')]").click();
        listOfNationalities.shouldBe(exactText(newNationality));
        return this;
    }

    public MyInfoPage changeMaritalStatus() {
        String currentMaritalStatus = maritalStatus.getText();
        maritalStatus.click();
        String newMaritalStatus = generateRandomOptionInList(listOfElementsInDorpDown);
        while (newMaritalStatus.equals(currentMaritalStatus) || newMaritalStatus.equals("-- Select --")){
            newMaritalStatus = generateRandomOptionInList(listOfElementsInDorpDown);
        }
        $x("//div[@role='listbox']/div[@role='option']/span[(text() = '"+ newMaritalStatus +"')]").click();
        maritalStatus.shouldBe(exactText(newMaritalStatus));
        return this;
    }

    public MyInfoPage saveMyInfoChanges (){
        savePersonalDetailsButton.scrollIntoView(true);
        savePersonalDetailsButton.submit();
        return this;
    }

    public MyInfoPage checkIfSuccessConfirmationPopUpAppears() {
        successConfirmationPopUp.shouldBe(visible);
        successConfirmationPopUp.shouldHave(text("Success\n Successfully Updated"));
        return this;
    }

}
