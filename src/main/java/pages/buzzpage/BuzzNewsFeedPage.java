package pages.buzzpage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.addempoyee.AddEmployeePage;
import pages.basepage.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class BuzzNewsFeedPage extends BasePage {
    private final SelenideElement textInput = $x("//textarea[@class = 'oxd-buzz-post-input']");
    private final SelenideElement postButton = $x("//button[@type= 'submit']");
    public final SelenideElement successConfirmationPopUp = $x("//div[@id='oxd-toaster_1']");
    public final SelenideElement newAddedPost = $x("(//div[@class= 'orangehrm-buzz-post-body'])[1]");

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
        newAddedPost.shouldBe(Condition.visible);
        newAddedPost.shouldHave(Condition.exactText(newPostText));
        return this;
    }

}
