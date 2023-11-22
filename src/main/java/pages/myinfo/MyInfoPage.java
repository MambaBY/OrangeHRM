package pages.myinfo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.basepage.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class MyInfoPage extends BasePage {
    public static final SelenideElement title = $x("//h6[text() = 'Personal Details']");
    public static final SelenideElement firstName = $x("//input[@name='firstName']");
    public static final SelenideElement lastName = $x("//input[@name='lastName']");



    public MyInfoPage checkTheTitle() {
        title.shouldBe(Condition.visible);
        return this;
    }


}
