import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class PlaylistTests extends BaseTest {

    @Test
    public void deletePlaylistTest() {

        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideLoginSucceed();
        homePage.chooseFirstPlaylist()
                .deletePlaylist();

        Assert.assertTrue(homePage.notificationText());
    }
}
