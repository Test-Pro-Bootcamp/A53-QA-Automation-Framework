import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {
        LoginPage login = new LoginPage(getThreadLocal());
        login.loadLoginPage();
        login.clickSubmit();
        HomePage homePage = new HomePage(getThreadLocal());
        Assert.assertFalse(homePage.avatarIsDisplayed());
    }
    @Test
    public void loginWrongPassword() {
        LoginPage login = new LoginPage(getThreadLocal());
        login.loadLoginPage();
        login.provideEmail("william.chang@testpro.io");
        login.providePassword("te$tStudentWW");
        login.clickSubmit();
        HomePage homePage = new HomePage(getThreadLocal());
        Assert.assertFalse(homePage.avatarIsDisplayed());
    }

    @Test
    public void loginUpdateEmail() throws InterruptedException {
        LoginPage login = new LoginPage(getThreadLocal());
        login.loginUsertoKoel();
        ProfilePage profilePage = new ProfilePage(getThreadLocal());
        profilePage.loadProfilePage();
        profilePage.updateEmail("te$tStudent1","william.chang1@testpro.io");
        profilePage.getSuccessNotification();
        Assert.assertEquals(profilePage.successNotificationText, "Profile updated.");
        profilePage.waitForSuccessNotificationDisappear();
        HomePage homePage = new HomePage(getThreadLocal());
        homePage.logOut();
        LoginPage newLogin = new LoginPage(getThreadLocal());
        newLogin.loadLoginPage();
        newLogin.provideEmail("william.chang1@testpro.io");
        newLogin.providePassword("te$tStudent1");
        newLogin.clickSubmit();
        Assert.assertTrue(homePage.avatarIsDisplayed());

        //revert for future tests
        profilePage.loadProfilePage();
        profilePage.updateEmail("te$tStudent1","william.chang@testpro.io");
        profilePage.getSuccessNotification();
        Assert.assertEquals(profilePage.successNotificationText, "Profile updated.");
    }

    @Test
    public void loginUpdatePassword() throws InterruptedException {
        LoginPage login = new LoginPage(getThreadLocal());
        login.loginUsertoKoel();
        ProfilePage profilePage = new ProfilePage(getThreadLocal());
        profilePage.loadProfilePage();
        profilePage.updatePassword("te$tStudent1","test$tudent1");
        profilePage.getSuccessNotification();
        Assert.assertEquals(profilePage.successNotificationText, "Profile updated.");
        profilePage.waitForSuccessNotificationDisappear();
        HomePage homePage = new HomePage(getThreadLocal());
        homePage.logOut();
        LoginPage newLogin = new LoginPage(getThreadLocal());
        newLogin.loadLoginPage();
        newLogin.provideEmail("william.chang@testpro.io");
        newLogin.providePassword("test$tudent1");
        newLogin.clickSubmit();
        Assert.assertTrue(homePage.avatarIsDisplayed());

        //revert for future tests
        profilePage.loadProfilePage();
        profilePage.updatePassword("test$tudent1","te$tStudent1");
        profilePage.getSuccessNotification();
        Assert.assertEquals(profilePage.successNotificationText, "Profile updated.");
    }
    @Test
    public void loginTest() {

        LoginPage login = new LoginPage(getThreadLocal());
        login.loginUsertoKoel();
        HomePage homePage = new HomePage(getThreadLocal());
        Assert.assertTrue(homePage.avatarIsDisplayed());
    }


}
