package pages.pim;

import com.codeborne.selenide.SelenideElement;
import pages.basepage.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class PimPage extends BasePage {
    private final SelenideElement addButton = $x("//button[text()=' Add ']");

    public PimPage clickAddButton() {
        addButton.click();
        return this;
    }
}
