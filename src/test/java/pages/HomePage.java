package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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


}
