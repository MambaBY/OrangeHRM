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
public class AddNewPostTestWithoutImage extends BaseTest {
    @Test
    @Owner("spaulovich")
    @Step("Add a new post without an attachment to the feed.")
    @Parameters({"newPostText"})
    public void addNewPost(String newPostText) throws IOException {
        basePage.openLoginPage();
        loginPage.enterUserLogin(VALID_LOGIN)
                .enterUserPassword(VALID_PASSWORD)
                .clickLoginButton();
        basePage.clickLeftSideMenuButton(buzzMenu);
        buzzNewsFeedPage.typeNewPost(newPostText)
                .clickPostButton()
                .checkIfSuccessConfirmationPopUpAppears();
        basePage.clickLeftSideMenuButton(buzzMenu);
        buzzNewsFeedPage.checkIfNewPostAddedToFeed(newPostText);

        takeScreenshot();
    }
}
