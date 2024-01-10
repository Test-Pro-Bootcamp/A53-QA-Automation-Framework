import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework18 extends BaseTest{
@Test
    public void playSong() throws InterruptedException{
        Thread.sleep(2000);
        provideEmail("demo@class.com");
        Thread.sleep(2000);
        providePassword("te$t$tudent");
        Thread.sleep(2000);
        clickSubmit();

        clickPlay();
        Assert.assertTrue(isSongPlaying());
    }


    public void clickPlay() throws InterruptedException{
        WebElement playNextBtn = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

        playNextBtn.click();
        Thread.sleep(2000);
        playBtn.click();
        Thread.sleep(2000);
    }
    public boolean isSongPlaying(){
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
    }
}
