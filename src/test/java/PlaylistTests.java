import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.SongListingPage;

import java.net.MalformedURLException;

public class PlaylistTests extends BaseTest {

    @Test
    public void deletePlaylistTest() throws MalformedURLException {

        LoginPage loginPage = new LoginPage(BaseTest.getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmail("john.wolschleger@testpro.io");
        loginPage.providePassword("te$t$tudentb49");
        loginPage.clickSubmit();

        homePage.clickPlaylistsGrid();
        homePage.clickDeletePlaylistBtn();

        String expectedPlaylistDeletedMessage = "Deleted playlist \"Homework17.\"";
        Assert.assertEquals(homePage.getDeletePlaylistSuccessMsg(), expectedPlaylistDeletedMessage);

    }

    @Test
    public void addSongToPlaylistTest() throws MalformedURLException {

        String expectedSongAddedMessage = "Added 1 song into \"Homework.\"";

        LoginPage loginPage = new LoginPage(BaseTest.getThreadLocal());
        SongListingPage songListingPage = new SongListingPage(BaseTest.getThreadLocal());


        loginPage.provideEmail("john.wolschleger@testpro.io");
        loginPage.providePassword("te$t$tudentb49");
        loginPage.clickSubmit();
        songListingPage.searchField.sendKeys("Pluto");
        songListingPage.viewAllBtn.click();
        songListingPage.firstSongResult.click();
        songListingPage.addToBtn.click();
        songListingPage.choosePlaylist();

        Assert.assertEquals(songListingPage.getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);
    }
}