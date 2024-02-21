import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework_18 extends BaseTest {
    @Test
    public void playSong() throws Throwable {
        LoginTest user = new LoginTest();
        user.loginToKoelApp();
        Thread.sleep(2000);

        WebElement musicControl = driver.findElement(By.xpath("//span[@title='Play or resume']"));
        Actions mouse = new Actions(driver);
        mouse.moveToElement(musicControl).build().perform();
        musicControl.click();
        Thread.sleep(2000);

        WebElement playNextSong = driver.findElement(By.xpath("//i[@title='Play next song']"));
        playNextSong.click();
        Thread.sleep(2000);
        mouse.moveToElement(musicControl).build().perform();
        WebElement pauseButton = driver.findElement(By.xpath("//span[@title='Pause']"));
        boolean status = pauseButton.isDisplayed();
        Assert.assertTrue(status);
        System.out.println("Homework 18 is done");


    }

}
