import Pages.AllSongsPage;
import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SongsTest extends BaseTest {
    @Test(priority = 0)
    public void playSongsByRightClick() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        BasePage basePage = new BasePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.login();

        homePage.goToAllSongsList();
        allSongsPage.contextClickFirstSong();
        allSongsPage.choosePlayOption();
        //Assertions
        Assert.assertTrue(basePage.isSongPlaying());
    }
    @Test(priority = 1)
    public void addSongToPlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        BasePage basePage = new BasePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.login();

        homePage.goToAllSongsList();
        allSongsPage.contextClickFirstSong();
        allSongsPage.addToButton();
        allSongsPage.selectExistPlayList();
        Assert.assertTrue(allSongsPage.verifyAddSongToPlaylistMessage());
    }

}



//countSongsInPlaylist
