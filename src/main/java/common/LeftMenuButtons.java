package common;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LeftMenuButtons {
    public static final SelenideElement pimMenu = $x("(//li[@class = 'oxd-main-menu-item-wrapper'])[2]");
}
