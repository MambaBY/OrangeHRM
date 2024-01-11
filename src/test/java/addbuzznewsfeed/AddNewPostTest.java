package addbuzznewsfeed;

import basetest.BaseTest;
import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import static common.LeftMenuButtons.buzzMenu;

@Listeners({ ScreenShooter.class})
public class AddNewPostTest extends BaseTest {
    @Test
    @Owner("spaulovich")
    @Step("Add a new post without an attachment to the feed.")
    @Parameters({"newPostText"})
    public void addNewPost(String newPostText) throws IOException {
        basePage.openLoginPage();
        loginPage.enterUserLogin()
                .enterUserPassword()
                .clickLoginButton();
        basePage.clickLeftSideMenuButton(buzzMenu);
        buzzNewsFeedPage.typeNewPost(newPostText)
                .clickPostButton()
                .checkIfSuccessConfirmationPopUpAppears();
        basePage.clickLeftSideMenuButton(buzzMenu);
        buzzNewsFeedPage.checkIfNewPostAddedtoFeed(newPostText);
        takeScreenshot();
    }

    @Test
    @Owner("spaulovich")
    @Step("Add a new post with a photo to the feed.")
    @Parameters({"newPostTextInPopUp"})
    public void addNewPostWithPhoto(String newPostTextForThePopUp) throws IOException {
        buzzNewsFeedPage.clickSharePhotoButton()
                .checkIfSharePhotoPopUpIsOpened()
                .typeNewPostInPopUpWindow(newPostTextForThePopUp)
                .uploadPhoto()
                .clickShareButton()
                .checkIfSuccessConfirmationPopUpAppears()
                .checkIfNewPostAddedtoFeed(newPostTextForThePopUp);
        takeScreenshot();
    }
}
