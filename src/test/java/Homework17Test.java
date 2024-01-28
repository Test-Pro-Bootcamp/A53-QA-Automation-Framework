import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.lang.Thread;
import java.time.Duration;

public class Homework17Test extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        LoginPage login = new LoginPage(getThreadLocal());
        login.loginUsertoKoel();


        getThreadLocal().findElement(By.xpath("//input[@type='search']")).sendKeys("Pluto");
        getThreadLocal().findElement(By.xpath("//input[@type='search']")).click();
        getThreadLocal().findElement(By.xpath("//button[@data-test='view-all-songs-btn']")).click();
        Thread.sleep(2000);


        getThreadLocal().findElement(By.xpath("//*[@id='songResultsWrapper']//tr[@class='song-item']")).click();
        getThreadLocal().findElement(By.xpath("//button[@class='btn-add-to']")).click();
        Thread.sleep(2000);

        getThreadLocal().findElement(By.xpath("//*[@id='songResultsWrapper']//li[@class='playlist']")).click();

        WebDriverWait w = new WebDriverWait(getThreadLocal(),Duration.ofSeconds(3));
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='success show']")));
        WebElement successPopup = getThreadLocal().findElement(By.xpath("//*[@class='success show']"));
        Assert.assertEquals(successPopup.getText(),"Added 1 song into \"NewPlaylist.\"");
        Thread.sleep(2000);

    }
}