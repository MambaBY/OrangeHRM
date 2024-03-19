package common;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;


public class GenerateRandomValues {
    /*
     * Method that generates random string value(only letters). Method is using for username creation.
    */
    public static String generateRandomName(int length) {
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

    /*
     * Method that generates random string value(only numbers). Method is using for userID creation.
     */
    public static String generateRandomUserID(int length) {
        boolean useLetters = false;
        boolean useNumbers = true;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

    /*
     * Method that generates random string value(letters and numbers). Method is using for driver license creation.
     */
    public static String generateRandomDriversLicenseNumber(int length) {
        boolean useLetters = true;
        boolean useNumbers = true;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

    /*
     * Method that is selecting random value in the dropdown
     */
    public static String generateRandomOptionInList(ElementsCollection collection){
        List<String> options = new ArrayList<>();
        for (SelenideElement element : collection) {
            options.add(element.getText());
        }
        SecureRandom random = new SecureRandom();
        return options.get(random.nextInt(options.size()));
    }
}
