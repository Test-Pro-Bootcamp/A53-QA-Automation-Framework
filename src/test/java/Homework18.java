import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong()  {

        navigateToPage();
        provideEmail("azahn007@gmail.com");
        providePassword("Koelpass");
        clickSubmit();
        clickPlayBtn();
        Assert.assertTrue(isSongPlaying());

    }




    public void clickPlayBtn()  {
        WebElement nextSong = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        nextSong.click();
        playBtn.click();



    }


    public boolean isSongPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
    }
}
