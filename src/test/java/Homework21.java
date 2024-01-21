import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.List;

public class Homework21 extends BaseTest{
    @Test
    @Parameters({"baseURL", "username", "password", "playlistName", "newPlaylistName"})
    void renamePlaylist(String baseURL, String username, String password, String playlistName, String newPlaylistName) throws InterruptedException {
        //GIVEN
        navigateTo(baseURL);
        loginToPlayer(username, password);
        //WHEN
        List<WebElement> playlists =  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#playlists ul li a")));
        WebElement targetPlaylist = null;
        for (WebElement playlist: playlists) {
            if (playlist.getText().equals(playlistName)) {
                targetPlaylist = playlist;
                break;
            }
        }
        try {
            actions.contextClick(targetPlaylist).perform();
            WebElement editPlaylistNameBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav[@class=\"menu playlist-item-menu\"]//li[text()='Edit']")));
            editPlaylistNameBtn.click();
            WebElement playlistNameInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid=\"inline-playlist-name-input\"]")));
            playlistNameInputField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
            playlistNameInputField.sendKeys(newPlaylistName);
            playlistNameInputField.sendKeys(Keys.RETURN);
            //THEN
            WebElement confirmationNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//div[@class='alertify-logs top right']/div[text()= 'Updated playlist \"" + newPlaylistName + ".\"']")));
            Assert.assertTrue(confirmationNotification.isDisplayed());
        }
        catch (Exception e) {
            System.out.println("The playlist you're trying to rename does not exist!");
            throw e;
        }
    }
}
