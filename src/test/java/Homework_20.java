import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework_20 extends BaseTest {


    @Test
    public void explicitWait() throws Throwable {
        LoginTest user = new LoginTest();
        user.loginToKoelApp();

        try {
            WebElement playList = driver.findElement(By.xpath("//li[@class='playlist playlist']"));
            elementToBeClickable(playList);
            playList.click();
            WebElement deletePlaylist = driver.findElement(By.xpath("//button[@title='Delete this playlist']"));
            deletePlaylist.click();
            WebElement deleteOk = driver.findElement(By.xpath("//button[@class='ok']"));
            elementToBeClickable(deleteOk);
            deleteOk.click();
            verifyDeleteNotification();
        } catch (Exception e) {
            WebElement addButton = driver.findElement(By.xpath("//i[@title='Create a new playlist']"));
            elementToBeClickable(addButton);
            addButton.click();
            WebElement newPlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]//li[text()='New Playlist']"));
            elementToBeClickable(newPlaylist);
            newPlaylist.click();
            WebElement savePlaylist = driver.findElement(By.xpath("//input[@placeholder='↵ to save']"));
            savePlaylist.sendKeys("SatyTest");
            savePlaylist.sendKeys(Keys.ENTER);
            WebElement notification = driver.findElement(By.xpath("//div[@class='success show']"));
            elementToBeClickable(notification);
            elementToDisappear("//div[@class='success show']");
            WebElement deletePlaylist = driver.findElement(By.xpath("//button[@title='Delete this playlist']"));
            elementToBeClickable(deletePlaylist);
            deletePlaylist.click();
            verifyDeleteNotification();
        }
    }

    public void verifyDeleteNotification() throws Throwable {
        WebElement notification = driver.findElement(By.xpath("//div[@class='success show']"));
        elementToBeClickable(notification);
        String notificationText = notification.getText();
        Assert.assertEquals("Deleted playlist \"SatyTest.\"", notificationText);
        System.out.println("Playlist deleted successfully");
    }
}
