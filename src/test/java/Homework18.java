import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends LoginTests {

    @Test
    public void playSong() throws InterruptedException {
        loginValidEmailPassword();
        Thread.sleep(2000);
        playMusic();
        Thread.sleep(2000);
    }

    public void playMusic(){
        WebElement playNextSongButton = driver.findElement(By.cssSelector("i[title='Play next song']"));
        playNextSongButton.click();

        WebElement playButton = driver.findElement(By.cssSelector("span[title='Play or resume']"));
        playButton.click();

        WebElement pauseButton = driver.findElement(By.cssSelector("span[title='Pause']"));
        Assert.assertTrue(pauseButton.isDisplayed());
    }

}
