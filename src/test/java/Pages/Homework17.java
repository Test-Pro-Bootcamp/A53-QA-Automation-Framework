package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    @Test
    public  void addSongToPlaylist() throws Throwable{
            loginToKoelApp();
            verifyLogin();
            searchSong();
            viewAllSearchList();
            selectFirstSongInTheResult();
            clickAddOnButton();
            choosePlaylist();
            verifyAddSongNotification();
            //createPlaylist();

        }

        public void verifyLogin() throws Throwable {
            WebElement yourMusic = driver.findElement(By.xpath("//span[@class='name']"));
            boolean status = yourMusic.isEnabled();
            Assert.assertTrue(status);
        }
        public void searchSong() throws Throwable {
            Thread.sleep(2000);
            WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
            search.sendKeys("For the poor");
        }

        public void viewAllSearchList() throws Throwable {
            Thread.sleep(2000);
            WebElement viewAll = driver.findElement(By.xpath("(//section[@class='songs']//button)[1]"));
            viewAll.click();
        }

        public void selectFirstSongInTheResult() throws Throwable {
            Thread.sleep(2000);
            WebElement viewAll = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//div//div//tr[1]"));
            viewAll.click();
        }
        public void clickAddOnButton() throws Throwable {
            Thread.sleep(2000);
            WebElement addTo = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/span/button[2]"));
            addTo.click();
        }

        public void choosePlaylist() throws Throwable {
            Thread.sleep(2000);
            WebElement myPlaylist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'SatyTest')]"));
            myPlaylist.click();
        }

        public void verifyAddSongNotification() throws Throwable {
            Thread.sleep(2000);
            WebElement notification = driver.findElement(By.xpath("//div[@class='success show']"));
            String notificationText = notification.getText();
            Assert.assertEquals("Added 1 song into \"SatyTest.\"", notificationText);
            System.out.println("Song added to the playlist");

        }
}
