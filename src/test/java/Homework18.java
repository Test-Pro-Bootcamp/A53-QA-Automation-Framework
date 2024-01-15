import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends Homework17 {
    @Test
    void playSong() throws InterruptedException{
        loginToPlayer(emailAddr, password);
        clickNextSong();
        Thread.sleep(1000);
        clickPlay();
        Thread.sleep(4000);
        WebElement pauseBtn = driver.findElement(By.cssSelector("[title='Pause']"));
        Assert.assertTrue(pauseBtn.isEnabled());

    }


    void clickNextSong() {
        WebElement nextSongBtn = driver.findElement(By.cssSelector("[title='Play next song']"));
        nextSongBtn.click();
    }

    void clickPlay() {
        WebElement playButton = driver.findElement(By.cssSelector("[title='Play or resume']"));
        playButton.click();

    }




}
