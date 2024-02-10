import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.QueuePage;
import pages.SongsPage;

public class SongPlayerTests extends BaseTest {
    @BeforeMethod
    public void loginToKoel(){
        LoginPage login = new LoginPage(getThreadLocal());
        login.loginUsertoKoel();
    }
    @Test
    public void playSong() {
        SongsPage songsPage = new SongsPage(getThreadLocal());
        songsPage.addSongsToQueue();
        QueuePage queuePage = new QueuePage(getThreadLocal());
        queuePage.loadQueuePage();
        queuePage.selectFirstSongQueue();
        Assert.assertTrue(queuePage.soundBarIsDisplayed());
    }

    @Test
    public void playNextSong() {
        SongsPage songsPage = new SongsPage(getThreadLocal());
        songsPage.addSongsToQueue();
        QueuePage queuePage = new QueuePage(getThreadLocal());
        queuePage.loadQueuePage();
        queuePage.selectFirstSongQueue();
        queuePage.clickPlayNext();
        Assert.assertTrue(queuePage.soundBarIsDisplayed());
    }
}
