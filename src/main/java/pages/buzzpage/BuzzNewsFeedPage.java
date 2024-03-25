package pages.buzzpage;

import pages.basepage.BasePage;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static constants.Constants.ValidationMassages.DATA_SAVED_CONFIRMATION_POPUP;
import static pages.buzzpage.BuzzFeedPageElementsSelectors.*;


public class BuzzNewsFeedPage extends BasePage {


    /**
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
        successConfirmationPopUp.shouldHave(text(DATA_SAVED_CONFIRMATION_POPUP));
        return this;
    }

    /*
     * Method checks that a new post appeared in the feed
     */
    public BuzzNewsFeedPage checkIfNewPostAddedToFeed(String newPostText){
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
        // TODO Could you get rid of sleeps? Could you configure waiting for elements?
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
        // TODO Will it be valid for all OS? Could Paths.get() be better?
        inputPhoto.uploadFile(new File("src/test/resources/Photo/image.jpeg"));
        uploadedPhotoInPopUp.shouldBe(visible);
        return this;
    }

}
