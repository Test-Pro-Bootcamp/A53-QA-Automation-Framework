import Pages.HomePage;
import Pages.LoginPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);

        loginPage.provideEmail("Andrew.Simmons@testpro.io");
        loginPage.providePassword("Andrew.Simmons24");
        loginPage.clickSubmit();

        searchPage.findSearchBar("Dark Days");
        searchPage.clickViewAllButton();
        searchPage.clickFirstSong();
        searchPage.clickaddToButton();
        searchPage.clickAddToPlaylist();

        Assert.assertTrue(searchPage.findSuccessAlertMsg().isDisplayed());

    }
}
