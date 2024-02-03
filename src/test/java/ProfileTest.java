import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class ProfileTest extends BaseTest{

    @Test(priority = 0)
    public void changeProfileName()throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        String randomNewName = profilePage.generateRandomName();
        loginPage.login();
        profilePage.clickOnAvatar();
        profilePage.provideCurrentPassword("te$t$tudent");
        profilePage.provideNewName(randomNewName);
        profilePage.clickSave();
        Thread.sleep(2000);
        //profilePage.getSuccessPopUp();
        //Asset
        WebElement actualProfileName = getDriver().findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(), randomNewName);
        //Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(By.cssSelector("div.success.show")), randomNewName);
    }

}



//updateProfileNameTest
//changeThemeTest