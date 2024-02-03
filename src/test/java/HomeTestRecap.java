import Pages.AllSongsPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTestRecap extends BaseTest{

    @Test(enabled = true,groups = {"Regression"},priority = 0, description = "Hover over play button test")
    public void hoverOverPlayBtnTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage songsPage = new AllSongsPage(getDriver());
        loginPage.login();
        homePage.goToAllSongsList();
        homePage.hoverPlay();
        Assert.assertTrue(homePage.hoverPlay().isDisplayed());
    }

    @Test(enabled = true,groups = {"Regression"},priority = 1, description = "Search a song test")
    public void searchSongTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login();
        homePage.searchSong("Take my Hand (ID 1696)");
        homePage.viewAllSearchResults();
    }
}
