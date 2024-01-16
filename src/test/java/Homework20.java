import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{
    @Test
    @Parameters({"baseURL", "username", "password", "playlistLocator"})
    void deletePlaylist(String baseURL, String username, String password, String playlistLocator) throws InterruptedException {
        navigateTo(baseURL);
        loginToPlayer(username, password);
        WebElement playlist = driver.findElement(By.xpath(playlistLocator));
        playlist.click();
        WebElement deleteBtn = driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        deleteBtn.click();
        WebElement confirmationNotification = driver.findElement(By.xpath("//div[@class='alertify-logs top right']/div[text()= 'Deleted playlist \"Custom.\"']"));
        Assert.assertTrue(confirmationNotification.isDisplayed());
    }
}
