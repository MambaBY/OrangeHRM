package common;
import org.apache.commons.lang3.RandomStringUtils;


public class GenerateRandomUserNameAndUserID {
    /*
     * Method that generates random string value. Method is using for username creation.
    */
    public static String generateRandomName(int lenght) {
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(lenght, useLetters, useNumbers);
    }

    public static String generateRandomUserID(int lenght) {
        boolean useLetters = false;
        boolean useNumbers = true;
        return RandomStringUtils.random(lenght, useLetters, useNumbers);
    }

    public static String generateRandomDriversLicenseNumber(int lenght) {
        boolean useLetters = true;
        boolean useNumbers = true;
        return RandomStringUtils.random(lenght, useLetters, useNumbers);
    }
}
