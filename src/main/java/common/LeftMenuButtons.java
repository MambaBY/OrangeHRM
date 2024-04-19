package common;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Class contains paths to the left menu buttons
 */
public class LeftMenuButtons {
    /**
     * 'PIM' menu
     */
    public static final SelenideElement pimMenu = $(By.linkText("PIM"));

    /**
     * 'My info' menu
     */
    public static final SelenideElement myInfo = $(By.linkText("My Info"));

    /**
     * 'Buzz' menu
     */
    public static final SelenideElement buzzMenu = $(By.linkText("Buzz"));
}
