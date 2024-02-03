import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTestRecap extends BaseTest {

    @Test(priority = 0)
    public void createNewPlaylistTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login();
        homePage.createPlaylist("New Test Playlist");
        //Assertions
        Assert.assertTrue(homePage.isPlaylistCreatedMessageDisplayed());
    }


    /*
    * Rename Existing Playlist, there is a problem that failed with the same name
    * */
//    @Test(priority = 1)
//    public void renameExistPlaylist() {
//        LoginPage loginPage = new LoginPage(driver);
//        HomePage homePage = new HomePage(driver);
//        BasePage basePage = new BasePage(driver);
//        String updatePlaylistMsg = "Updated playlist \"Sample Edited Playlist.\"";
//        String newPlaylistName = "Sample Edited Playlist";
//
//        loginPage.login();
//        basePage.doubleClickPlaylistElement(By.cssSelector(".playlist:nth-child(4)"));
//        homePage.enterNewPlaylistName(newPlaylistName, By.cssSelector("[name='name']"));
//        //Assertions
//        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(By.cssSelector("div.success.show")), updatePlaylistMsg);
//    }
    @Test(priority = 1)
    public void renameNewPlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        String newPlaylistName = "New Name Playlist";
        loginPage.login();
        homePage.createPlaylist("defaultName");
        homePage.choosePlaylistByName("defaultName");
        homePage.doubleClickChoosePlaylistByName("defaultName");
        homePage.enterNewPlaylistName(newPlaylistName, By.cssSelector("[name='name']"));
        //Assertions
        //Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(By.cssSelector("div.success.show")), updatePlaylistMsg);
        Assert.assertTrue(homePage.playlistRenamedMsgIsDisplayed());
    }

    @Test(priority = 2)
    public void deleteEmptyPlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //String expectedDeletePlaylistMessage = "Deleted playlist \"Test Pro Playlist.\"";

        loginPage.login();
        homePage.openPlaylistToDelete();
        homePage.clickDeletePlaylistBtn();
        //Assertions
        //Assert.assertEquals(homePage.getDeleteMessage(), expectedDeletePlaylistMessage);
        Assert.assertTrue(homePage.isplaylistDeleted());
    }
}
