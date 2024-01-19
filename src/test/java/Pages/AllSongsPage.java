package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage{

    public AllSongsPage(WebDriver givenDriver){
        super(givenDriver);
    }

    //Elements

    By firstSongInAllSongs = By.cssSelector(".all-songs tr.song-item:nth-child(1)");

    By playBtnInContextMeny = By.cssSelector("li.playback");

    //Methods

    public WebElement firstSongInAllSongs (){
        return findElementUsingByLocator(firstSongInAllSongs);
    }

    public void contextClickFirstSong() throws InterruptedException{
        WebElement firstSongInTheList = wait.until(ExpectedConditions
                .visibilityOfElementLocated(firstSongInAllSongs));
        actions.contextClick(firstSongInTheList).perform();
    }

    public void choosePlayOption() throws InterruptedException{
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(playBtnInContextMeny)).click();
    }


}
