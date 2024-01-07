package common;
import org.apache.commons.lang3.RandomStringUtils;


public class GenerateRandomValues {
    /*
     * Method that generates random string value(only letters). Method is using for username creation.
    */
    public static String generateRandomName(int lenght) {
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(lenght, useLetters, useNumbers);
    }

    /*
     * Method that generates random string value(only numbers). Method is using for userID creation.
     */
    public static String generateRandomUserID(int lenght) {
        boolean useLetters = false;
        boolean useNumbers = true;
        return RandomStringUtils.random(lenght, useLetters, useNumbers);
    }

    /*
     * Method that generates random string value(letters and numbers). Method is using for driver license creation.
     */
    public static String generateRandomDriversLicenseNumber(int lenght) {
        boolean useLetters = true;
        boolean useNumbers = true;
        return RandomStringUtils.random(lenght, useLetters, useNumbers);
    }
}
