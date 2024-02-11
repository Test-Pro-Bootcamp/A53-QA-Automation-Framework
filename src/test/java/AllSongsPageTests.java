import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class AllSongsPageTests extends BaseTest {
    @Test(enabled = true, priority = 2, description = "Playing the first song from all songs")
    public void playFirstSongFromAllSongs() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        loginPage.loginWithValidCredentials();
        loginPage.assertSuccessfulLogin();
        homePage.goToAllSongs();
        Thread.sleep(2000);
    }
}
