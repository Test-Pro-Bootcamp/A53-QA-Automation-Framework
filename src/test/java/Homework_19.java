import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework_19 extends BaseTest {
    @Test
    public void deletePlaylist() throws Throwable {
        Thread.sleep(2000);
        try {
            WebElement playList = driver.findElement(By.xpath("//li[@class='playlist playlist']"));
            playList.click();
        } catch (Exception e) {
            Thread.sleep(2000);
            WebElement addButton = driver.findElement(By.xpath("//i[@title='Create a new playlist']"));
            addButton.click();
            Thread.sleep(2000);
            WebElement newPlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]//li[text()='New Playlist']"));
            newPlaylist.click();
            WebElement savePlaylist = driver.findElement(By.xpath("//input[@placeholder='↵ to save']"));
            savePlaylist.sendKeys("SatyTest");
            Thread.sleep(1000);
            savePlaylist.sendKeys(Keys.ENTER);
            Thread.sleep(4000);
        }

        WebElement deletePlaylist = driver.findElement(By.xpath("//button[@title='Delete this playlist']"));
        deletePlaylist.click();
        Thread.sleep(2000);
        WebElement notification = driver.findElement(By.xpath("//div[@class='success show']"));
        String notificationText = notification.getText();
        Assert.assertEquals("Deleted playlist \"SatyTest.\"", notificationText);
        System.out.println("Playlist deleted successfully");

    }
}
