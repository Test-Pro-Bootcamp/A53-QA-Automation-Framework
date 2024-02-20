import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class Homework21 extends BaseTest{

    //Prerequisite - at least one user-created playlist
    String newPlaylistName = "Renamed Playlist";

    @Test
    public void renamePlaylist() {

        String updatedPlaylistMsg = "Updated playlist \"Renamed Playlist.\"";
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmail("dmitry.lobachev@testpro.io");
        loginPage.providePassword("Chebyreki5!");
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);

        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);
    }
}