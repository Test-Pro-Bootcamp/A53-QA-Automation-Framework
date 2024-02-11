import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class HomePageTests extends BaseTest {

    //@Test (enabled = true, priority = 2, description = "Creating a new playlist")
    public void createNewPlaylist() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithValidCredentials();
        loginPage.assertSuccessfulLogin();
        String playlistName = "BrandNew";
        homePage.createNewPlaylist(playlistName);
    }
}
