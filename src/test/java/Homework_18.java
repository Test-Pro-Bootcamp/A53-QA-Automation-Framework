import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework_18 extends BaseTest {
    @Test
    public void playSong() throws Throwable {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.sendKeys("burul.satybaeva@testpro.io");
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.sendKeys("Lulkerup7710%");
        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submitButton.click();
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


    }

}
