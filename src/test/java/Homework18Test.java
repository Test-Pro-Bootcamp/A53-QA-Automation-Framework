import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.Thread;
import java.time.Duration;

public class Homework18Test {
WebDriver driver;

    public void loginUser(){
        String url = "https://qa.koel.app/";
        driver.get(url);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("william.chang@testpro.io");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("te$tStudent");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void addSongstoQueue(){
        driver.findElement(By.xpath("//a[@href='#!/songs']")).click();
        driver.findElement(By.xpath("//*[@id='songsWrapper']//tr[@class='song-item'][1]")).click();
        driver.findElement(By.xpath("//button[@class='btn-add-to']")).click();
        driver.findElement(By.xpath("//*[@id='songsWrapper']//li[@class='bottom-queue']")).click();
        driver.findElement(By.xpath("//*[@id='songsWrapper']//tr[@class='song-item'][2]")).click();
        driver.findElement(By.xpath("//button[@class='btn-add-to']")).click();
        driver.findElement(By.xpath("//*[@id='songsWrapper']//li[@class='bottom-queue']")).click();
    }
    @Test
    public void playSong() throws InterruptedException {
//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions act = new Actions(driver);

        loginUser();
        //play-next button is optimal when songs are added to queue
        addSongstoQueue();

        driver.findElement(By.xpath("//a[@href='#!/queue']")).click();
        act.doubleClick(driver.findElement(By.xpath("//*[@id='queueWrapper']//tr[@class='song-item'][1]"))).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//i[@data-testid='play-next-btn']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-testid='sound-bar-play']")).isDisplayed());
        Thread.sleep(2000);
        driver.quit();
    }
}
