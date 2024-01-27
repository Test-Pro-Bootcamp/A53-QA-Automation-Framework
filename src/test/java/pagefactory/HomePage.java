package pagefactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(css = "img[class='avatar']")
    WebElement avatarIcon;
    @FindBy(css = ".playlist:nth-child(3)")
    WebElement firstPlaylist;
    @FindBy(css = "[name='name']")
    WebElement playlistNameField;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Fluent interface
    public HomePage doubleClickPlaylist() {
        doubleClick(firstPlaylist);
        return this;
    }
    public HomePage enterNewPlaylistName(String playlistName) {
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
        return this;
    }

    //Changed the approach for assert
    public String getPlaylistName () {
        return findElement(firstPlaylist).getText();
    }
    public boolean isAvatarDisplayed() {
        return findElement(avatarIcon).isDisplayed();
    }


}