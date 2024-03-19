package pages.myinfo;

import pages.basepage.BasePage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static common.GenerateRandomValues.generateRandomDriversLicenseNumber;
import static common.HelperMethods.clearInputField;
import static common.HelperMethods.setNewOptionInDropDown;
import static constants.Constants.DatePatterns.DATE_FORMAT_PATTERN;
import static constants.Constants.LengthOfGeneratedRandomValues.DRIVER_LICENSE_NUMBER_LENGTH;
import static constants.Constants.ValidationMassages.DATA_UPDATED_CONFIRMATION_POPUP;
import static java.lang.Thread.sleep;
import static pages.myinfo.MyInfoPageElementsSelectors.*;

public class MyInfoPage extends BasePage {

    public MyInfoPage checkTheTitle() {
        title.shouldBe(visible);
        return this;
    }

    public MyInfoPage changeUserFirstName(String firstNameUpdated) throws InterruptedException {
        sleep(5000);
        clearInputField(firstName);
        firstName.setValue(firstNameUpdated);
        return this;
    }
    public MyInfoPage changeUserLastName(String lastNameUpdated) {
        clearInputField(lastName);
        lastName.setValue(lastNameUpdated);
        return this;
    }


    public MyInfoPage changeDriverLicenseNumber() {
        clearInputField(driverLicenseNumber);
        driverLicenseNumber.setValue(generateRandomDriversLicenseNumber(DRIVER_LICENSE_NUMBER_LENGTH));
        return this;
    }

    public MyInfoPage changeDriverLicenseExpiryDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 2);
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_PATTERN);
        String toDate = dateFormat.format(cal.getTime());
        clearInputField(driverLicenseExpiryDate);
        driverLicenseExpiryDate.setValue(toDate);
        driverLicenseExpiryDate.scrollIntoView(true);
        return this;
    }

    public MyInfoPage changeNationality() {
        setNewOptionInDropDown(preSelectedNationality, listOfElementsInDropDown, dynamicXpath);
        return this;
    }

    public MyInfoPage changeMaritalStatus() {
        setNewOptionInDropDown(preSelectedMaritalStatus, listOfElementsInDropDown,dynamicXpath);
        return this;
    }

    public MyInfoPage saveMyInfoChanges (){
        savePersonalDetailsButton.scrollIntoView(true);
        savePersonalDetailsButton.submit();
        return this;
    }

    public MyInfoPage checkIfSuccessConfirmationPopUpAppears() {
        successConfirmationPopUp.shouldBe(visible);
        successConfirmationPopUp.shouldHave(text(DATA_UPDATED_CONFIRMATION_POPUP));
        return this;
    }

}
