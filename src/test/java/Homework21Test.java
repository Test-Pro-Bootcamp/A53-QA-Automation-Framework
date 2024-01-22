import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;


public class Homework21Test extends BaseTest {

    @Test
    public void renamePlaylist() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.loginUsertoKoel();
        Actions act = new Actions(driver);
        driver.findElement(By.xpath("//li[@class='playlist playlist'][1]")).click();
        act.doubleClick(driver.findElement(By.xpath("//li[@class='playlist playlist'][1]"))).perform();

        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3));
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-testid='inline-playlist-name-input']")));
        WebElement playlistInput = driver.findElement(By.xpath("//input[@data-testid='inline-playlist-name-input']"));
        //Following line only works on mac
        playlistInput.sendKeys(Keys.chord(Keys.COMMAND,"a",Keys.DELETE));
        //Added for windows
        playlistInput.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        playlistInput.sendKeys("RenamedPlaylist", Keys.ENTER);


        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='success show']")));
        WebElement successPopup = driver.findElement(By.xpath("//*[@class='success show']"));
        Assert.assertEquals(successPopup.getText(), "Updated playlist \"RenamedPlaylist.\"");

    }
}