package pages.buzzpage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.basepage.BasePage;

import java.io.File;

import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Selenide.$x;

public class BuzzNewsFeedPage extends BasePage {
    private final SelenideElement textInput = $x("(//textarea[@class= 'oxd-buzz-post-input'])[1]");
    private final SelenideElement textInputInPopUpWindow =
            $x("(//textarea[@class= 'oxd-buzz-post-input'])[2]");
    private final SelenideElement postButton = $x("//button[@type= 'submit']");
    private final SelenideElement shareButtonInPopUp = $x("//button[text()= ' Share ']");
    public final SelenideElement successConfirmationPopUp = $x("//div[@id='oxd-toaster_1']");
    public final SelenideElement newAddedPost = $x("(//div[@class= 'orangehrm-buzz-post-body'])[1]");
    public final SelenideElement sharePhotoButton = $x("//button[text()= ' Share Photos']");
    public final SelenideElement sharePhotoPopUpTitle =$x("//p[text()= 'Share Photos']");
    //public final SelenideElement sharePhotoPopUp = $x("//div[@role = 'document']");
    public final SelenideElement inputPhoto = $x("//input[@type= 'file']");
    public final SelenideElement uploadedPhotoInPopUp = $x("//div[@class ='orangehrm-photo-input']//img");
    public final SelenideElement loadingSpiner = $x("//*[@class = 'oxd-loading-spinner']");


    public BuzzNewsFeedPage typeNewPost(String newPostText){
        textInput.shouldBe(Condition.visible);
        textInput.setValue(newPostText);
        return this;
    }

    public BuzzNewsFeedPage typeNewPostInPopUpWindow(String newPostText){
        textInputInPopUpWindow.shouldBe(Condition.visible);
        textInputInPopUpWindow.setValue(newPostText);
        return this;
    }

    public BuzzNewsFeedPage clickPostButton(){
        postButton.shouldBe(Condition.visible);
        postButton.submit();
        return this;
    }

    public BuzzNewsFeedPage clickShareButtonInPopUp(){
        shareButtonInPopUp.shouldBe(Condition.visible);
        shareButtonInPopUp.shouldNotBe(disabled);
        shareButtonInPopUp.submit();
        return this;
    }

    public BuzzNewsFeedPage checkIfSuccessConfirmationPopUpAppears() {
        successConfirmationPopUp.shouldBe(Condition.visible);
        successConfirmationPopUp.shouldHave(Condition.text("Success\n" + "Successfully Saved"));
        return this;
    }

    public BuzzNewsFeedPage checkIfNewPostAddedtoFeed(String newPostText){
        loadingSpiner.shouldNotBe(Condition.visible);
        newAddedPost.shouldBe(Condition.visible);
        newAddedPost.shouldHave(Condition.exactText(newPostText));
        return this;
    }

    public BuzzNewsFeedPage clickSharePhotoButton() throws InterruptedException {
        Thread.sleep(3000);
        loadingSpiner.shouldNotBe(Condition.visible);
        sharePhotoButton.shouldBe(Condition.visible);
        sharePhotoButton.click();
        return this;
    }

    public BuzzNewsFeedPage checkIfSharePhotoPopUpIsOpened(){
        sharePhotoPopUpTitle.shouldBe(Condition.visible);
        return this;
    }

    public BuzzNewsFeedPage uploadPhoto(){
        inputPhoto.uploadFile(new File("src/test/resources/Photo/image.jpeg"));
        uploadedPhotoInPopUp.shouldBe(Condition.visible);
        return this;
    }


}
