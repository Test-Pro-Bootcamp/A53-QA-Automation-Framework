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
            clickPlayNextSongBtn();
            clickPlaySongBtn();

}
        public void clickPlayNextSongBtn() throws InterruptedException {
        WebElement playNextSong = driver.findElement(By.xpath("//*[@id='mainFooter']/div[1]/i[2]"));
            playNextSong.click();
            Thread.sleep(2000);
        }
        public void clickPlaySongBtn() throws InterruptedException {
            WebElement playSong = driver.findElement(By.xpath("//*[@id='mainFooter']/div[1]/span/span[2]"));
            playSong.click();
            Thread.sleep(2000);
        }
               public void expectedVisualizerBanner() throws InterruptedException {
            WebElement visualizerBanner = driver.findElement(By.xpath("//*[@id=\"vizContainer\"] || //*[@id=\"mainFooter\"]/div[1]/span/span[2]/i"));

            Assert.assertTrue(visualizerBanner.isDisplayed());
          }
        }











