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
import static constants.Constants.UserCredentials.VALID_LOGIN;
import static constants.Constants.UserCredentials.VALID_PASSWORD;

@Listeners({ScreenShooter.class})
public class AddNewPostWithImageTest extends BaseTest {
    @Test
    @Owner("spaulovich")
    @Step("Add a new post with a photo to the feed.")
    @Parameters({"newPostTextInPopUp"})
    public void addNewPostWithImage(String newPostTextForThePopUp) throws IOException {
        basePage.openLoginPage();
        loginPage.enterUserLogin(VALID_LOGIN)
                .enterUserPassword(VALID_PASSWORD)
                .clickLoginButton();
        basePage.clickLeftSideMenuButton(buzzMenu);
        buzzNewsFeedPage.clickSharePhotoButton()
                        .checkIfSharePhotoPopUpIsOpened()
                        .typeNewPostInPopUpWindow(newPostTextForThePopUp)
                        .uploadPhoto()
                        .clickShareButtonInPopUp()
                        .checkIfSuccessConfirmationPopUpAppears()
                        .checkIfNewPostAddedToFeed(newPostTextForThePopUp)
                        .checkIfImageIsVisibleInTheAddedPost();
        takeScreenshot();
    }
}
