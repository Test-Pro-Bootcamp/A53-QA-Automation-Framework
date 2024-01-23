package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
//page locators
    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By playlistInputField = By.cssSelector("[name='name']");
    By renamePlaylistSuccessMsg = By.cssSelector("div.success.show");
    By userAvatarIcon = By.cssSelector("img.avatar");
    By allSongsList = By.cssSelector("li a.songs");
//page methods
    public void doubleClickPlaylist() {
        doubleClick(firstPlaylist);
    }
    public void enterNewPlaylistName(String playlistName) {
        findElementUsingByLocator(playlistInputField).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        findElementUsingByLocator(playlistInputField).sendKeys(playlistName);
        findElementUsingByLocator(playlistInputField).sendKeys(Keys.ENTER);
    }
    public String getRenamePlaylistSuccessMsg(){
        return findElementUsingByLocator(renamePlaylistSuccessMsg).getText();
    }
    public WebElement getUserAvatarIcon() {
        return findElementUsingByLocator(userAvatarIcon);
    }
    public WebElement allSongsList() {
        return findElementUsingByLocator(allSongsList);
    }
    public void goToAllSongsList(){
        findElementUsingByLocator(allSongsList).click();
    }
}
