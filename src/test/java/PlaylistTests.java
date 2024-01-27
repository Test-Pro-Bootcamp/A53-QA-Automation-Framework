import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;


public class PlaylistTests extends BaseTest {

    //    Fluent interfaces example from HW22

    @Test
    public void renamePlaylist(){
        String playlistName = "Test Pro Edited Playlist 2";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("demo@class.com")
                 .providePassword("te$t$tudent")
                 .clickSubmit();

        homePage.doubleClickPlaylist()
                .enterNewPlaylistName(playlistName);

        //Changed the approach for assert from HW22
        Assert.assertEquals(homePage.getPlaylistName(), playlistName);

    }
}