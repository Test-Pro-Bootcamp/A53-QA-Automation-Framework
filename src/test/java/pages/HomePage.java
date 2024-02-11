package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;

public class HomePage extends BasePage{
    public HomePage (WebDriver givenDriver) {
        super(givenDriver);
    }
    By home = By.cssSelector(".home");
    By currentQueue = By.cssSelector(".queue.active");
    By allSongs = By.cssSelector(".songs.active");
    By albums = By.cssSelector(".albums.active");
    By artists = By.cssSelector(".artists.active");
    By favorites = By.cssSelector(".playlist.favorites");
    By recentlyPlayed = By.cssSelector(".playlist.recently-played");
    By userProfile = By.cssSelector("[title='iew/edit user profile']");
    By aboutKoel = By.cssSelector("#searchForm input");
    By createNewPlaylist = By.cssSelector("[data-testid='sidebar-create-playlist-btn']");
    By newPlaylistContextMenu = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");
    By playlistNameInputField = By.cssSelector("[name='create-simple-playlist-form'] input");

    public void createNewPlaylist (String playlistName) {
        findElementByLocator(createNewPlaylist).click();
        findElementByLocator(newPlaylistContextMenu).click();
        WebElement playlistNameInput = findElementByLocator(playlistNameInputField);
        playlistNameInput.sendKeys(playlistName);
        playlistNameInput.sendKeys(Keys.RETURN);
        System.out.println("//li[@class='playlist playlist']/a[contains(text(), '" + playlistName + "')]");
        Assert.assertTrue(findElementByLocator(By.xpath("//li[@class='playlist playlist']/a[contains(text(), '" + playlistName + "')]")).isDisplayed());
    }

}
