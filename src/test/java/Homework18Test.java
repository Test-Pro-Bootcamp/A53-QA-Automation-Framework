import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.lang.Thread;
import java.time.Duration;

public class Homework18Test extends BaseTest {


    public void addSongstoQueue(){
        getThreadLocal().findElement(By.xpath("//a[@href='#!/songs']")).click();
        getThreadLocal().findElement(By.xpath("//*[@id='songsWrapper']//tr[@class='song-item'][1]")).click();
        getThreadLocal().findElement(By.xpath("//button[@class='btn-add-to']")).click();
        getThreadLocal().findElement(By.xpath("//*[@id='songsWrapper']//li[@class='bottom-queue']")).click();
        getThreadLocal().findElement(By.xpath("//*[@id='songsWrapper']//tr[@class='song-item'][2]")).click();
        getThreadLocal().findElement(By.xpath("//button[@class='btn-add-to']")).click();
        getThreadLocal().findElement(By.xpath("//*[@id='songsWrapper']//li[@class='bottom-queue']")).click();
    }
    @Test
    public void playSong() throws InterruptedException {

        Actions act = new Actions(getThreadLocal());
        LoginPage login = new LoginPage(getThreadLocal());
        login.loginUsertoKoel();
        //play-next button is optimal when songs are added to queue
        addSongstoQueue();

        getThreadLocal().findElement(By.xpath("//a[@href='#!/queue']")).click();
        act.doubleClick(getThreadLocal().findElement(By.xpath("//*[@id='queueWrapper']//tr[@class='song-item'][1]"))).perform();
        Thread.sleep(2000);
        getThreadLocal().findElement(By.xpath("//i[@data-testid='play-next-btn']")).click();
        Assert.assertTrue(getThreadLocal().findElement(By.xpath("//*[@data-testid='sound-bar-play']")).isDisplayed());
        Thread.sleep(2000);
    }
}
