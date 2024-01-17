import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest{
    @Test
    public void playSongByContextClick() throws InterruptedException{
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        chooseAllSongsList();
        contextClickFirstSong();
        chooseplayOption();
        //Assertions
    }
    public void chooseAllSongsList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.a.song"))).click();
    }
    public void contextClickFirstSong() throws InterruptedException{
        WebElement firstSongInTheList = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongInTheList).perform();
    }
}


