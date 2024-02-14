// Homework19.java

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedPlaylistDeleteMessage = "Deleted playlist / 'TestPro PlayList./";

        provideEmail("vlad.sadokha@testpro.io");
        providePassword("democlass");
        clickSubmit();
        openPlaylist();
        clickDeletePlaylistBtn();
        Assert.assertEquals(getDeletedPlaylistMsg(), expectedPlaylistDeleteMessage);
    }

    public void openPlaylist() {
        WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        emptyPlaylist.click();
    }
    public void clickDeletePlaylistBtn() throws InterruptedException {
        WebElement deletePlaylist = driver.findElement(By.ByCssSelector("#playlistWrapper div.song-list-controls"));
        deletePlaylist.click();
        Thread.sleep(2000);
    }
    public void getDeletedPlaylistMsg() {
        WebElement notificationMsg = driver.findElement(By.ByCssSelector("div.alertify-logs.top.right"));
        return notificationMsg.getText();
    }


}
