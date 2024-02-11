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
    private By home = By.cssSelector(".home");
    private By currentQueue = By.cssSelector(".queue.active");
    private By allSongs = By.cssSelector(".songs.active");
    private By albums = By.cssSelector(".albums.active");
    private By artists = By.cssSelector(".artists.active");
    private By favorites = By.cssSelector(".playlist.favorites");
    private By recentlyPlayed = By.cssSelector(".playlist.recently-played");
    private By userProfile = By.cssSelector("[title='iew/edit user profile']");
    private By aboutKoel = By.cssSelector("#searchForm input");
    private By createNewPlaylistBtn = By.cssSelector("[data-testid='sidebar-create-playlist-btn']");
    private By newPlaylistContextMenu = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");
    private By playlistNameInputField = By.cssSelector("[name='create-simple-playlist-form'] input");

    public void createNewPlaylist (String playlistName) {
        findElementByLocator(createNewPlaylistBtn).click();
        findElementByLocator(newPlaylistContextMenu).click();
        WebElement playlistNameInput = findElementByLocator(playlistNameInputField);
        playlistNameInput.sendKeys(playlistName);
        playlistNameInput.sendKeys(Keys.RETURN);
        Assert.assertTrue(findElementByLocator(By.xpath("//li[@class='playlist playlist']/a[contains(text(), '" + playlistName + "')]")).isDisplayed());
    }

}
