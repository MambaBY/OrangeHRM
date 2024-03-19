package pages.buzzpage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BuzzFeedPageElementsSelectors {
    protected static final SelenideElement textInput = $("textarea.oxd-buzz-post-input");
    protected static final SelenideElement textInputInPopUpWindow =
            $x("(//textarea[@placeholder=\"What's on your mind?\"])[2]");
    protected static final SelenideElement postButton = $x("//button[@type= 'submit']");
    protected static final SelenideElement shareButtonInPopUp = $x("//button[text()= ' Share ']");
    protected static final SelenideElement successConfirmationPopUp = $(By.id("oxd-toaster_1"));
    protected static final SelenideElement newAddedPost =
            $x("(//div[@class= 'orangehrm-buzz-post-body'])[1]");
    protected static final SelenideElement imageInAddedPost =
            $x("(//div[@class= 'orangehrm-buzz-post-body'])[1]//img");
    protected static final SelenideElement sharePhotoButton = $x("//button[text()= ' Share Photos']");
    protected static final SelenideElement sharePhotoPopUpTitle =$x("//p[text()= 'Share Photos']");
    protected static final SelenideElement inputPhoto = $(".oxd-file-input");
    protected static final SelenideElement uploadedPhotoInPopUp =
                    $x("//div[@class ='orangehrm-photo-input']//img");
    protected static final SelenideElement loadingSpinner = $(".oxd-loading-spinner");
}
