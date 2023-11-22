package common;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

/*
 * Class contains paths to the left menu buttons
 */
public class LeftMenuButtons {
    /*
     * 'PIM' menu
     */
    public static final SelenideElement pimMenu = $x("(//li[@class = 'oxd-main-menu-item-wrapper'])[2]");

    /*
     * 'My info' menu
     */
    public static final SelenideElement myInfo = $x("(//li[@class = 'oxd-main-menu-item-wrapper'])[6]");
}
