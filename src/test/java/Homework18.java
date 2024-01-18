
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Homework18 extends BaseTest{

    WebDriver driver = new ChromeDriver();
    @Parameters({"BaseUrl"})

    @Test
    public void playSong(){
        provideEmail("vlad.sadokha@testpro.io");
        providePassword("Mukmuk11");
        clickSubmit();
        //clickPlay();
            //assertions
        Assert.assertTrue(isSongPlaying());
    }

    public void clickPlay(){
        WebElement  playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

        playNextButton.click();
        playButton.click();
    }
    public boolean isSongPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
    }

}
