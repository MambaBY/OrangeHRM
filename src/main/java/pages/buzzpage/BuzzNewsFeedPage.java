package pages.buzzpage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.basepage.BasePage;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;

public class BuzzNewsFeedPage extends BasePage {
    private final SelenideElement textInput = $x("//textarea[@class = 'oxd-buzz-post-input']");
    private final SelenideElement postButton = $x("//button[@type= 'submit']");
    public final SelenideElement successConfirmationPopUp = $x("//div[@id='oxd-toaster_1']");
    public final SelenideElement newAddedPost = $x("(//div[@class= 'orangehrm-buzz-post-body'])[1]");
    public final SelenideElement sharePhotoButton = $x("//button[text()= ' Share Photos']");
    public final SelenideElement sharePhotoPopUp = $x("//div[@role = 'document']");
    public final SelenideElement inputPhoto = $x("//input[@type= 'file']");
    public final SelenideElement uploadedPhotoInPopUp = $x("//div[@class ='orangehrm-photo-input']//img");


    public BuzzNewsFeedPage typeNewPost(String newPostText){
        textInput.shouldBe(Condition.visible);
        textInput.setValue(newPostText);
        return this;
    }

    public BuzzNewsFeedPage clickPostButton(){
        postButton.click();
        return this;
    }

    public BuzzNewsFeedPage checkIfSuccessConfirmationPopUpAppears() {
        successConfirmationPopUp.shouldBe(Condition.visible);
        successConfirmationPopUp.shouldHave(Condition.text("Success\n" + "Successfully Saved"));
        return this;
    }

    public BuzzNewsFeedPage checkIfNewPostAddwdtoFeed (String newPostText){
        successConfirmationPopUp.shouldNotBe(Condition.visible);
        newAddedPost.shouldBe(Condition.visible);
        newAddedPost.shouldHave(Condition.exactText(newPostText));
        return this;
    }

    public BuzzNewsFeedPage clickSharePhotoButton(){
        sharePhotoButton.shouldBe(Condition.visible);
        sharePhotoButton.click();
        return this;
    }

    public BuzzNewsFeedPage checkIfSharePhotoPopUpIsOpened(){
        sharePhotoPopUp.shouldBe(Condition.visible);
        return this;
    }

    public BuzzNewsFeedPage uploadPhoto(){
        inputPhoto.uploadFile(new File("src/test/resources/Photo/image.jpeg"));
        uploadedPhotoInPopUp.shouldBe(Condition.visible);
        return this;
    }


}
