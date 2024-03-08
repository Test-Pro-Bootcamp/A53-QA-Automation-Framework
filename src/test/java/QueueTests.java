import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class QueueTests extends BaseTest {
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
    public void songDisplayedQueue() {
        SongsPage songsPage = new SongsPage(getThreadLocal());
        songsPage.loadAllSongsPage();
        songsPage.playSongsFirstElement();
        QueuePage queuePage = new QueuePage(getThreadLocal());
        queuePage.loadQueuePage();
        Assert.assertTrue(queuePage.getFirstSongTitle().contains("M33 Project"));
    }

    @Test
    public void songCountIsDisplayed() {
        SongsPage songsPage = new SongsPage(getThreadLocal());
        songsPage.addSongsToQueue();
        QueuePage queuePage = new QueuePage(getThreadLocal());
        queuePage.loadQueuePage();
        Assert.assertTrue(queuePage.getSongCount().contains("2 songs"));
    }

    @Test
    public void songInfoIsDisplayed() {
        SongsPage songsPage = new SongsPage(getThreadLocal());
        songsPage.addSongsToQueue();
        QueuePage queuePage = new QueuePage(getThreadLocal());
        queuePage.loadQueuePage();
        Assert.assertEquals(queuePage.getFirstSongTitle(),"M33 Project - Emotional Soundtrack");
        Assert.assertEquals(queuePage.getFirstSongAlbum(),"Unknown Album");
        Assert.assertEquals(queuePage.getFirstSongArtist(),"Unknown Artist");
        Assert.assertEquals(queuePage.getFirstSongDuration(),"02:47");
        Assert.assertTrue(queuePage.getFirstSongID());

    }

    @Test
    public void shuffleTest() {
        SongsPage songsPage = new SongsPage(getThreadLocal());
        songsPage.addThreeSongsToQueue();
        QueuePage queuePage = new QueuePage(getThreadLocal());
        queuePage.loadQueuePage();
        queuePage.clickShuffleAllBtn();
        Assert.assertTrue(queuePage.checkShuffling("M33 Project - Emotional Soundtrack"));
    }

    @Test
    public void durationIsDisplayed() {
        SongsPage songsPage = new SongsPage(getThreadLocal());
        songsPage.addSongsToQueue();
        QueuePage queuePage = new QueuePage(getThreadLocal());
        queuePage.loadQueuePage();
        Assert.assertTrue(queuePage.getTotalSongDuration().contains("04:30"));
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

    @Test
    public void queuePageRedirection() {
        AlbumPage albumPage = new AlbumPage(getThreadLocal());
        albumPage.loadAlbumPage();
        albumPage.selectSongElement();
        QueuePage queuePage = new QueuePage(getThreadLocal());
        Assert.assertEquals(queuePage.getActualPageUrl(),"https://qa.koel.app/#!/queue");
        ArtistPage artistPage = new ArtistPage(getThreadLocal());
        artistPage.loadArtistPage();
        artistPage.selectSongElement();
        Assert.assertEquals(queuePage.getActualPageUrl(),"https://qa.koel.app/#!/queue");
    }
    @Test
    public void queueClearTest() {
        SongsPage songsPage = new SongsPage(getThreadLocal());
        songsPage.addSongsToQueue();
        QueuePage queuePage = new QueuePage(getThreadLocal());
        queuePage.loadQueuePage();
        queuePage.clickClearQueueBtn();
        Assert.assertTrue(queuePage.isNoSongQueuedMsg());
    }
    @Test
    public void clearShuffleAdditionTest() {
        SongsPage songsPage = new SongsPage(getThreadLocal());
        songsPage.addSongsToQueue();
        QueuePage queuePage = new QueuePage(getThreadLocal());
        queuePage.loadQueuePage();
        queuePage.clickClearQueueBtn();
        queuePage.clickStartShufflingLink();
        Assert.assertTrue(queuePage.getSongCount().contains("66 songs"));
    }

}
