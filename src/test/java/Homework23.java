import Pages.HomePage;
import Pages.LoginPage;
import Pages.PlaylistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework23 extends BaseTest {
    @Test
    public void deletePlaylistUsingPageFactory(){
       /* String newPlaylistName = "Test Pro Edited Playlist";
        String updatedPlaylistMsg = "Updated playlist \"Test Pro Edited Playlist.\"";*/

        LoginPage loginPage =new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);

        loginPage.provideEmailToLogin("azahn007@gmail.com").providePasswordToLogin("Koelpass").clickSubmitBtnToLogin();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='#!/playlist/83406']")));
        playlistPage.selectPlaylistToDelete();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
        playlistPage.clickAndDeletePlaylist();


        


    }
}

