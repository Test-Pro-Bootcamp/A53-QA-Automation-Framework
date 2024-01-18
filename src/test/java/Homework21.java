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
        navigateTo(baseURL);
        loginToPlayer(username, password);
        List<WebElement> playlists =  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#playlists ul li a")));
        for (WebElement playlist: playlists) {
            if (playlist.getText().equals(playlistName)) {
                actions.contextClick(playlist).perform();
                WebElement editPlaylistNameBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@class=\"menu playlist-item-menu\"]//li[text()='Edit']")));
                Thread.sleep(2000);
                editPlaylistNameBtn.click();
                WebElement playlistNameInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid=\"inline-playlist-name-input\"]")));
                playlistNameInputField.clear();
                Thread.sleep(2000);
                playlistNameInputField.sendKeys(newPlaylistName);
                playlistNameInputField.sendKeys(Keys.RETURN);
            }
        }
/*        createPlayList(playlistName);
        renamePlaylist(baseURL, username, password, playlistName, newPlaylistName);*/
    }
}
