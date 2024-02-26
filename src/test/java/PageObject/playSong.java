package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class playSong extends commonUtils {
   public static WebElement musicControl;
   public static Actions mouse;
    public void playTheSong() throws Throwable {

        WebElement music = driver.findElement(By.xpath("//span[@class='album-thumb']"));
        elementToBeVisible(music);
        musicControl = driver.findElement(By.xpath("//span[@title='Play or resume']"));
        mouse = new Actions(driver);
        mouse.moveToElement(musicControl).build().perform();
        clickElement(musicControl);
    }
        public void clickNextSong() throws Throwable {
            WebElement playNextSong = driver.findElement(By.xpath("//i[@title='Play next song']"));
            clickElement(playNextSong);
            elementToBeClickable(musicControl);
            mouse.moveToElement(musicControl).build().perform();
        }
        public void pauseSong() throws Throwable{
            WebElement pauseButton = driver.findElement(By.xpath("//span[@title='Pause']"));
            elementToBeClickable(pauseButton);
            boolean status = pauseButton.isDisplayed();
            Assert.assertTrue(status);
            System.out.println("Homework 22 is done");
    }
}



