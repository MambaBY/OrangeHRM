package addbuzznewsfeed;

import basetest.BaseTest;
import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.buzzpage.BuzzNewsFeedPage;

import java.io.IOException;

import static common.LeftMenuButtons.buzzMenu;

@Listeners({ ScreenShooter.class})
public class AddNewPostTest extends BaseTest {
    @Test
    @Owner("spaulovich")
    @Step("Add a new user to the system.")
    @Parameters({"newPostText"})
    public void addNewPost (String newPostText) throws IOException {
        basePage.openLoginPage();
        loginPage.enterUserLogin()
                .enterUserPassword()
                .clickLoginButton();
        basePage.clickLeftSideMenuButton(buzzMenu);
        buzzNewsfeedPage.typeNewPost(newPostText)
                        .clickPostButton()
                        .checkIfSuccessConfirmationPopUpAppears()
                        .checkIfNewPostAddwdtoFeed(newPostText);

        takeScreenshot();
    }

}
