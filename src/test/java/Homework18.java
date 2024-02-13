import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException{
        navigateToPage();
        provideEmail("constantin@moraresco.com");
        providePassword("Nastika20$");
        clickSubmit();
        clickPlay();
        Assert.assertTrue(isSongPlaying());
        

    }

    public boolean isSongPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//*[@data-testid =\"sound-bar-play\"]"));
        return soundBar.isDisplayed();
    }

    public void clickPlay() {
        WebElement playNextButton = driver.findElement(By.xpath("//*[@id=\"mainFooter\"]/div[1]/i[2]"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid ='play-btn']"));
        playNextButton.click();
        playButton.click();
    }


}
