import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String expectedSongAddedMessage = "Added 1 song into"/ "/Testpro playlist./";
        thread.sleep(2000)

        navigateToUrl();
        provideEmail("vlad.sadokha@testpro.io");
        providePassword("democlass");
        clickSubmit();
        searchSong();
        clickViewAllBtn();
        selectFirstSongResult()
        choosePLaylist();
        //Assertion v

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //Start with searchSong(); input[type='email']

        public void choosePlayList() throws InterruptedException {
            WebElement playList = driver.findElement(By.xpath("span[class='details']"));
            playList.click();
            Thread.sleep(2000);
        }

        public void selectFirstSongResult() throws InterruptedException {
            WebElement firstSong = driver.findElement(By.cssSelector("span[class='details']"));
            firstSong.click();
            Thread.sleep(2000);
        }

        public void clickViewAllBtn() throws InterruptedException {
            WebElement enterKey = driver.findElement(By.xpath("//section[@id='songResultsWrapper']"));
            enterKey.click();
            Thread.sleep(2000);
        }

        public void searchSong(String songName) throws InterruptedException {
            WebElement searchField = driver.findElement(By.cssSelector("div#searchFrom input[type='search']"));
            searchField.sendKeys("dark days");
            searchField.click(songName);
        }

        public void clickSubmit() throws InterruptedException {
            WebElement firstSong = driver.findElement(By.cssSelector("span[class='details']"));
            firstSong.click();
            Thread.sleep(2000);
        }

        public void providePassword() throws InterruptedException {
            WebElement firstSong = driver.findElement(By.cssSelector("span[class='details']"));
            firstSong.click();
            Thread.sleep(2000);
        }

        public void provideEmail() throws InterruptedException {
            WebElement firstSong = driver.findElement(By.cssSelector("span[class='details']"));
            firstSong.click();
            Thread.sleep(2000);
        }

        public void navigateToUrl() throws InterruptedException {
            WebElement firstSong = driver.findElement(By.cssSelector("span[class='details']"));
            firstSong.click();
            Thread.sleep(2000);
        }


    }
}
