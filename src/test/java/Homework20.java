import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;


public class Homework20 extends BaseTest{
    @Test
    @Parameters({"baseURL", "username", "password", "playlistLocator", "playlistName"})
    void deletePlaylist(String baseURL, String username, String password, String playlistLocator) throws InterruptedException {
        navigateTo(baseURL);
        loginToPlayer(username, password);
        List<WebElement> playlists =  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#playlists ul li")));
        for (WebElement playslist: playlists) {
            if (playlists.getText() == ) {

            }
        }


        createPlayList("Custom");
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(playlistLocator)));
        playlist.click();
        WebElement deleteBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Delete this playlist']")));
        deleteBtn.click();
        WebElement confirmationNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//div[@class='alertify-logs top right']/div[text()= 'Deleted playlist \"Custom.\"']")));
        Assert.assertTrue(confirmationNotification.isDisplayed());
    }

    void createPlayList(String playlistName) {
        WebElement createPlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid=\"sidebar-create-playlist-btn\"]")));
        createPlaylistBtn.click();
        WebElement newPlaylistSubmenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid=\"playlist-context-menu-create-simple\"]")));
        newPlaylistSubmenu.click();
        WebElement playlistNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@name=\"create-simple-playlist-form\"]/input\n")));
        playlistNameInput.sendKeys(playlistName);
        playlistNameInput.sendKeys(Keys.RETURN);


    }
}
