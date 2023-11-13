package common;
import org.apache.commons.lang3.RandomStringUtils;


public class GenerateRandomUserName {
    /*
     * Method that generates random string value. Method is using for username creation.
    */
    public static String generateRandomName(int lenght) {
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(lenght, useLetters, useNumbers);
    }
}
