package pages.myinfo;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MyInfoPageElementsSelectors {
    protected static final SelenideElement title = $x("//h6[text() = 'Personal Details']");
    protected static final SelenideElement firstName =$(By.name("firstName"));
    protected static final SelenideElement lastName =$(By.name("lastName"));
    protected static final SelenideElement driverLicenseNumber =
            $x("//label[text() = \"Driver's License Number\"]/following::input[1]");
    protected static final SelenideElement driverLicenseExpiryDate =
            $x("//label[text() = 'License Expiry Date']/following::input[1]");
    protected static final SelenideElement preSelectedNationality =
            $x("//label[text()='Nationality']/following::div[1]");
    protected static final ElementsCollection listOfElementsInDropDown =
            $$x("//div[@role='listbox']/div");
    protected static final SelenideElement preSelectedMaritalStatus =
            $x("//label[text()='Marital Status']/following::div[1]");
    protected static final SelenideElement savePersonalDetailsButton =
            $x("(//button[@type='submit'])[1]");
    protected static final SelenideElement successConfirmationPopUp = $(By.id("oxd-toaster_1"));

    protected static final String dynamicXpath = "//div[@role='listbox']/div[@role='option']/span[(text() = '%s')]";
}
