package pages.buzzpage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.basepage.BasePage;

import java.io.File;

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
    public final SelenideElement imageInAddedPost =
            $x("(//div[@class= 'orangehrm-buzz-post-body'])[1]//img");
    public final SelenideElement sharePhotoButton = $x("//button[text()= ' Share Photos']");
    public final SelenideElement sharePhotoPopUpTitle =$x("//p[text()= 'Share Photos']");
    public final SelenideElement inputPhoto = $x("//input[@type= 'file']");
    public final SelenideElement uploadedPhotoInPopUp = $x("//div[@class ='orangehrm-photo-input']//img");
    public final SelenideElement loadingSpiner = $x("//*[@class = 'oxd-loading-spinner']");

    /*
     * Method types a text in input field
     */
    public BuzzNewsFeedPage typeNewPost(String newPostText){
        textInput.shouldBe(Condition.visible);
        textInput.setValue(newPostText);
        return this;
    }

    /*
     * Method types a text in input field in pop up window
     */
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

    /*
     * Method checks confirmation window after a new post submitted
     */
    public BuzzNewsFeedPage checkIfSuccessConfirmationPopUpAppears() {
        successConfirmationPopUp.shouldBe(Condition.visible);
        successConfirmationPopUp.shouldHave(Condition.text("Success\n" + "Successfully Saved"));
        return this;
    }

    /*
     * Method checks that a new post appeared in the feed
     */
    public BuzzNewsFeedPage checkIfNewPostAddedtoFeed(String newPostText){
        loadingSpiner.shouldNotBe(Condition.visible);
        newAddedPost.shouldBe(Condition.visible);
        newAddedPost.shouldHave(Condition.exactText(newPostText));
        return this;
    }

    public BuzzNewsFeedPage checkIfImageIsVisibleInTheAddedPost() {
        imageInAddedPost.shouldBe(Condition.visible);
        return this;
    }

    public BuzzNewsFeedPage clickSharePhotoButton() throws InterruptedException {
        Thread.sleep(3000);
        loadingSpiner.shouldNotBe(Condition.visible);
        sharePhotoButton.shouldBe(Condition.visible);
        sharePhotoButton.click();
        return this;
    }

    /*
     * Method checks if a pop-up window opened
     */
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
