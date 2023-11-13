package common;
import org.apache.commons.lang3.RandomStringUtils;


public class GenerateRandomUserName {

    public static String generateRandomName(int lenght) {
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(lenght, useLetters, useNumbers);
    }

//    public static String generateRandomPassword(int lenght) {
//        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!#$%^&*";
//        return RandomStringUtils.random(lenght, chars);
//    }
}
