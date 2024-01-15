import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomeWork18 extends BaseTest{

    @Test
    public void playSong() {


        provideEmail("demo@class.com");
        providePassword("te$tStudent");
        clickSubmit();
        //clickPlay()
        //Assertions
    }

     public void clickPlay() {
         WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testtid='play-next-btn']"));
         WebElement playButton = driver.findElement(By.xpath("span[@data-testid='play-btn']"));

         playNextButton.click();
         playButton.click();
     }
     public boolean isSongPlaying() {
         WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
                 return soundBar.isDisplayed();
     }


}