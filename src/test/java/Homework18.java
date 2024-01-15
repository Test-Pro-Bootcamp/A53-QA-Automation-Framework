import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;


public class Homework18 extends BaseTest {
    private WebElement songIsPlaying;

    @Test
    public void playSong() throws InterruptedException {
        logIn ("ramya.gudur@testpro.io","Ammananna@65");

       enterAllSongs();
       selectSong();
       enterButtonPlaySong();
        Assert.assertTrue(isDisplayedPlayingSong());
    }
    public boolean isDisplayedPlayingSong() {
    WebElement SongIsPlaying = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
    return songIsPlaying.isDisplayed();}
       public void enterAllSongs() throws InterruptedException {
        WebElement allSongs = driver.findElement(By.cssSelector("a[href='#!/songs']"));
        Thread.sleep(1000);
        allSongs.click();
    }

    public void selectSong() throws InterruptedException {
        WebElement Song = driver.findElement(By.xpath("//tr[@class='song-item']"));
        Thread.sleep(1000);
        Song.click();
    }
    public void enterButtonPlaySong() {
        WebElement buttonPlaySong = driver.findElement(By.xpath("//span[@title='Play or resume']"));
        Actions actions = new Actions(driver);
        actions.click(buttonPlaySong).perform();
    }

    public void logIn(String email,String password) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("invalid@class.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

    }
}










