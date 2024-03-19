package common;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$x;
import static common.GenerateRandomValues.generateRandomOptionInList;


public class HelperMethods {

    /*
     * Method that clear pre-filled data in input fields
     */
    public static void clearInputField(SelenideElement element){
        element.sendKeys(Keys.CONTROL + "A");
        element.sendKeys(Keys.BACK_SPACE);
    }


    /*
     * Method that set new option for dropdown fields
     */
    public static void setNewOptionInDropDown(SelenideElement preSelectedElement,
                                              ElementsCollection listOfElementsInDropdown,
                                              String dynamicXpath) {
        String currentOption = preSelectedElement.getText();
        preSelectedElement.click();
        String newOption = generateRandomOptionInList(listOfElementsInDropdown);
        while (newOption.equals(currentOption) || newOption.equals("-- Select --")){
            newOption = generateRandomOptionInList(listOfElementsInDropdown);
        }
        SelenideElement newElement = $x(String.format(dynamicXpath, newOption));
        newElement.click();
        preSelectedElement.shouldBe(exactText(newOption));
    }
}
