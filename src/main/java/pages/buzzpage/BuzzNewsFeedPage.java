package pages.buzzpage;

import pages.basepage.BasePage;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    /**
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

    /**
     * Method checks confirmation window after a new post submitted
     */
    public BuzzNewsFeedPage checkIfSuccessConfirmationPopUpAppears() {
        successConfirmationPopUp.shouldBe(visible);
        successConfirmationPopUp.shouldHave(text(DATA_SAVED_CONFIRMATION_POPUP));
        return this;
    }

    /**
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

    public BuzzNewsFeedPage clickSharePhotoButton() {
        loadingSpinner.shouldNotBe(visible);
        sharePhotoButton.shouldBe(visible);
        sharePhotoButton.shouldBe(clickable);
        sharePhotoButton.click();
        return this;
    }

    /**
     * Method checks if a pop-up window opened
     */
    public BuzzNewsFeedPage checkIfSharePhotoPopUpIsOpened(){

        sharePhotoPopUpTitle.shouldBe(visible);
        shareButtonInPopUp.shouldBe(visible);
        shareButtonInPopUp.shouldNotBe(clickable);
        return this;
    }

    public BuzzNewsFeedPage uploadPhoto(){
        Path filePath = Paths.get("src/test/resources/Photo/image.jpeg");
        inputPhoto.uploadFile(new File(String.valueOf(filePath)));
        uploadedPhotoInPopUp.shouldBe(visible);
        return this;
    }
}
