import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{
    @Test
    @Parameters({"baseURL", "username", "password", "playlistLocator"})
    void deletePlaylist(String baseURL, String username, String password, String playlistLocator) {
        navigateTo(baseURL);
        loginToPlayer(username, password);
        deletePlaylistHelper(playlistLocator);
        WebElement confirmationNotification = driver.findElement(By.xpath("//div[@class='alertify-logs top right']/div[text()= 'Deleted playlist \"Custom.\"']"));
        Assert.assertTrue(confirmationNotification.isDisplayed());

    }
    void deletePlaylistHelper(String PlaylistXpathLocator) {
        WebElement playlist = driver.findElement(By.xpath(PlaylistXpathLocator));
        playlist.click();
        WebElement deleteBtn = driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        deleteBtn.click();
    }

}
