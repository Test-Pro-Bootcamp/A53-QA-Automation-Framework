import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest {
    @Test
    public void renamePlaylist(){
        String newPlaylistName = "Test Pro Edited Playlist";
        String updatedPlaylistMsg = "Updated playlist \"Test Pro Edited Playlist.\"";

        LoginPage loginPage =new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(),updatedPlaylistMsg);


    }
}
