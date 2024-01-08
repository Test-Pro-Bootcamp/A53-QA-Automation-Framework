import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException{

        driver.get(url);
        //Login
        //Email Field
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("andrew.simmons@testpro.io");
        //Password Field
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("Andrew.Simmons24");
        //Submit button
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        Thread.sleep(2000);


        //Play Next Song
        Actions actions = new Actions(driver);
        WebElement playButton = driver.findElement(By.cssSelector("span .play i"));
        actions.moveToElement(playButton).perform();
        playButton.click();

        Thread.sleep(5000);

        //Verify Sound Bar or Pause Button
        WebElement pauseButton = driver.findElement(By.cssSelector(".pause"));
        Assert.assertTrue(pauseButton.isDisplayed());

        driver.quit();

    }


}
