import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;


public abstract class Homework18<webElement> extends BaseTest {


    @Test
    public void playSong() {
        provideEmail("ramya.gudur@testpro.io");
        providePassword("Ammananna@65");
        clickSubmit();
        //clickPlay()
        //Assertions
        Assert.assertTrue(isSongPlaying());
    }


    public void clickPlay() {

        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

        playNextButton.click();
        playButton.click();

    }

    public boolean isSongPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));

        return ((WebElement) soundBar).isDisplayed();
    }
}



