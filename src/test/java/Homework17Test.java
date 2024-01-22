import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.Thread;
import java.time.Duration;

public class Homework17Test extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("william.chang@testpro.io");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("te$tStudent");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Pluto");
        driver.findElement(By.xpath("//input[@type='search']")).click();
        driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']")).click();
        Thread.sleep(2000);


        driver.findElement(By.xpath("//*[@id='songResultsWrapper']//tr[@class='song-item']")).click();
        driver.findElement(By.xpath("//button[@class='btn-add-to']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='songResultsWrapper']//li[@class='playlist']")).click();

        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(3));
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='success show']")));
        WebElement successPopup = driver.findElement(By.xpath("//*[@class='success show']"));
        Assert.assertEquals(successPopup.getText(),"Added 1 song into \"NewPlaylist.\"");
        Thread.sleep(2000);
        driver.quit();
    }
}