package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class playSong extends BasePage {
    public playSong(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Element Locators using page factory
    @FindBy(xpath = "//span[@class='album-thumb']")
    WebElement music;
    @FindBy(xpath = "//span[@title='Play or resume']")
    WebElement musicControl;
    @FindBy(xpath = "//i[@title='Play next song']")
    WebElement playNextSong;
    @FindBy(xpath = "//span[@title='Pause']")
    WebElement pauseButton;

    // Methods using Selenium Page Factory.
    public WebElement findMusicButton(){
      return findElementUsingByLocator(music);
    }
    public WebElement clickPlaySongButton(){
        mouse.moveToElement(findElementUsingByLocator(music)).build().perform();
        findElementUsingByLocator(musicControl).click();
        return musicControl;
    }

    public WebElement clickNextSong(){
        findElementUsingByLocator(playNextSong).click();
        mouse.moveToElement(findElementUsingByLocator(music)).build().perform();
        return playNextSong;
    }
    public WebElement pauseSong(){
        WebElement pauseButton = findElementUsingByLocator(this.pauseButton);
        boolean status = pauseButton.isDisplayed();
        Assert.assertTrue(status);
        System.out.println("Homework 23 is done");
        return playNextSong;
    }
}



