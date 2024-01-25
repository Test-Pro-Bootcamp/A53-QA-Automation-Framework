import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.SongsPage;

import java.net.MalformedURLException;

public class SongsTest extends BaseTest {

    @Test
    public void playSongTest() throws MalformedURLException {

        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        SongsPage songsPage = new SongsPage(getThreadLocal());

        loginPage.provideEmail("john.wolschleger@testpro.io");
        loginPage.providePassword("te$t$tudentb49");
        loginPage.clickSubmit();

        songsPage.playNextSong.click();
        songsPage.playSong.click();

        Assert.assertTrue(songsPage.visualizerBanner.isDisplayed());
      }
    }