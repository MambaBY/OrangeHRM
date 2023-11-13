package common;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

/*
 * Class contains paths to the left menu buttons
 */
public class LeftMenuButtons {
    public static final SelenideElement pimMenu = $x("(//li[@class = 'oxd-main-menu-item-wrapper'])[2]");
}
