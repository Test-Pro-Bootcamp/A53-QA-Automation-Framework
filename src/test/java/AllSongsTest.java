import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllSongsTest extends BaseTest {


    public Actions actions = new Actions(driver);
    @Test
    public void playSongByContextClick() throws InterruptedException{

        navigateToUrl(url);
        provideEmail("andrew.simmons@testpro.io");
        providePassword("Andrew.Simmons24");
        clickSubmit();

        chooseAllSongsList();
        contextClickFirstSong();
        choosePlayOption();

        Assert.assertTrue(isSongPlaying());

    }

    @Test
    public void hoverOverPlayBtn() {
        navigateToUrl(url);
        provideEmail("andrew.simmons@testpro.io");
        providePassword("Andrew.Simmons24");
        clickSubmit();

        Assert.assertTrue(hoverPlay().isDisplayed());

    }

    public void chooseAllSongsList() throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }

    public void contextClickFirstSong() throws InterruptedException{
        WebElement firstSongInTheList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongInTheList).perform();
    }

    public void choosePlayOption() throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(("li.playback")))).click();
    }

    public boolean isSongPlaying() throws InterruptedException{
        WebElement soundBarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        return soundBarVisualizer.isDisplayed();
    }

    public WebElement hoverPlay(){
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(playBtn).perform();
        return wait.until(ExpectedConditions.visibilityOf(playBtn));
    }

}
