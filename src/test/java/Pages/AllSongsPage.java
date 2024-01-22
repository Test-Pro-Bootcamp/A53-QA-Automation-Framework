package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage{

    public AllSongsPage(WebDriver givenDriver){super(givenDriver);}


    By firstSongInAllSongs = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
    By playBtnContextMeny = By.cssSelector("li.playback");


    public WebElement firstSongInAllSongs(){
        return findElementUsingByLocator(firstSongInAllSongs);
    }
    public void contextClickFirstSong(){
        WebElement firstSongInTheList = wait.until(ExpectedConditions
                .visibilityOfElementLocated(firstSongInAllSongs));
        actions.contextClick(firstSongInTheList).perform();
        //actions.contextClick(findElementUsingByLocator(firstSongInAllSongs).perform();
    }
    public void choosePlayOption(){
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(playBtnContextMeny)).click();
    }



}
