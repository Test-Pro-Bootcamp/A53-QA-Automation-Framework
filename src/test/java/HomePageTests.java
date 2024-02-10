import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTests extends BaseTest {

    @Test (enabled = true, priority = 2, description = "Creating a new playlist")
    public void newPlaylist() {
        HomePage homePage = new HomePage(driver);
        String playlistName = "BrandNew";
        homePage.createNewPlaylist(playlistName);

    }
}
