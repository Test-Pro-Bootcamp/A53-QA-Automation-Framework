package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SongsPage extends BasePage {
    protected WebDriver driver;

    protected WebDriverWait wait;

    protected Actions actions;

    public SongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(xpath = "//i[@data-testid='play-next-btn']")
    public WebElement playNextSong;

    @FindBy(xpath = "//span[@data-testid='play-btn']")
    public WebElement playSong;

    @FindBy(xpath = "//div[@data-testid='sound-bar-play']")
    public WebElement visualizerBanner;

    public void clickPlayNextSong() {
    }

    public void clickPlaySong() {
    }

    public boolean visualizerBanner() {
        return visualizerBanner.isDisplayed();
  }
}