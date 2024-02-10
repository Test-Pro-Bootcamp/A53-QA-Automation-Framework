import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class PlaylistTests extends BaseTest {
    HomePage homePage;
    @BeforeMethod
    public void loginToKoel(){
        LoginPage login = new LoginPage(getThreadLocal());
        login.loginUsertoKoel();
    }

    public void createNewPlaylist(){

        homePage = new HomePage(getThreadLocal());
        homePage.clickCreatePlaylistBtn();
        homePage.selectNewPlaylistMenuItem();
        homePage.createNewPlaylist();
        homePage.getSuccessNotification();
        Assert.assertEquals(homePage.successNotificationText,"Created playlist \"NewPlaylist.\"");
        homePage.waitForSuccessNotificationDisappear();
    }

    public void deletePlaylist(String playlistName) {

        homePage = new HomePage(getThreadLocal());
        homePage.selectPlaylistElement();
        homePage.clickDeletePlaylistBtn();
        homePage.getDeleteNotification();
        Assert.assertEquals(homePage.successNotificationText,"Deleted playlist \"" + playlistName + ".\"");
        homePage.waitForSuccessNotificationDisappear();
    }


    @Test
    public void addSongToPlaylist() {

        homePage = new HomePage(getThreadLocal());
        createNewPlaylist();
        homePage.clickSearch();
        homePage.searchSongPluto();
        homePage.selectViewAllSongsBtn();
        homePage.selectSong();
        homePage.selectAddToPlaylist();
        homePage.selectPlaylist();
        homePage.getSuccessNotification();
        Assert.assertEquals(homePage.successNotificationText,"Added 1 song into \"NewPlaylist.\"");
        homePage.waitForSuccessNotificationDisappear();
        deletePlaylist("NewPlaylist");
    }
    @Test
    public void renamePlaylist() {
        homePage = new HomePage(getThreadLocal());
        createNewPlaylist();
        homePage.selectPlaylistElement();
        homePage.renamePlaylistElementNewPlaylist("RenamedPlaylist");
        homePage.getSuccessNotification();
        Assert.assertEquals(homePage.successNotificationText, "Updated playlist \"RenamedPlaylist.\"");
        homePage.waitForSuccessNotificationDisappear();
        deletePlaylist("RenamedPlaylist");
    }
}
