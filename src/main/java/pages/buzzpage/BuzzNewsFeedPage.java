package pages.buzzpage;

import pages.basepage.BasePage;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static pages.buzzpage.BuzzFeedPageElementsSelectors.*;


public class BuzzNewsFeedPage extends BasePage {


    /*
     * Method types a text in input field
     */
    public BuzzNewsFeedPage typeNewPost(String newPostText){
        textInput.shouldBe(visible);
        textInput.setValue(newPostText);
        return this;
    }

    /*
     * Method types a text in input field in pop up window
     */
    public BuzzNewsFeedPage typeNewPostInPopUpWindow(String newPostText){
        textInputInPopUpWindow.shouldBe(visible);
        textInputInPopUpWindow.setValue(newPostText);
        return this;
    }

    public BuzzNewsFeedPage clickPostButton(){
        postButton.shouldBe(visible);
        postButton.submit();
        return this;
    }

    public BuzzNewsFeedPage clickShareButtonInPopUp(){
        shareButtonInPopUp.shouldBe(visible);
        shareButtonInPopUp.shouldNotBe(disabled);
        shareButtonInPopUp.submit();
        return this;
    }

    /*
     * Method checks confirmation window after a new post submitted
     */
    public BuzzNewsFeedPage checkIfSuccessConfirmationPopUpAppears() {
        successConfirmationPopUp.shouldBe(visible);
        successConfirmationPopUp.shouldHave(text("Success\n Successfully Saved"));
        return this;
    }

    /*
     * Method checks that a new post appeared in the feed
     */
    public BuzzNewsFeedPage checkIfNewPostAddedtoFeed(String newPostText){
        loadingSpinner.shouldNotBe(visible);
        newAddedPost.shouldBe(visible);
        newAddedPost.shouldHave(exactText(newPostText));
        return this;
    }

    public BuzzNewsFeedPage checkIfImageIsVisibleInTheAddedPost() {
        imageInAddedPost.shouldBe(visible);
        return this;
    }

    public BuzzNewsFeedPage clickSharePhotoButton() throws InterruptedException {
        Thread.sleep(3000);
        loadingSpinner.shouldNotBe(visible);
        sharePhotoButton.shouldBe(visible);
        sharePhotoButton.click();
        return this;
    }

    /*
     * Method checks if a pop-up window opened
     */
    public BuzzNewsFeedPage checkIfSharePhotoPopUpIsOpened(){
        sharePhotoPopUpTitle.shouldBe(visible);
        return this;
    }

    public BuzzNewsFeedPage uploadPhoto(){
        inputPhoto.uploadFile(new File("src/test/resources/Photo/image.jpeg"));
        uploadedPhotoInPopUp.shouldBe(visible);
        return this;
    }

}
