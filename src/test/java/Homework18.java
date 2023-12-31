import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
        public class Homework18 extends BaseTest {
        @Test
        public void playSong() throws InterruptedException {

            navigateToPage();
            provideEmail("john.wolschleger@testpro.io");
            providePassword("te$t$tudentb49");
            clickSubmit();
            Thread.sleep(2000);
            clickPlay();
            Assert.assertTrue(expectedVisualizerBanner());
}
        public void clickPlay() throws InterruptedException {
        WebElement playNextSong = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playSong = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

            playNextSong.click();
            playSong.click();
            Thread.sleep(2000);
        }
               public boolean expectedVisualizerBanner() {
            WebElement visualizerBanner = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
            return visualizerBanner.isDisplayed();
          }
        }