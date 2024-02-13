import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Homework20 extends BaseTest {
    @Parameters({"BaseUrl"})
    @Test
    public void deletePlaylist() throws InterruptedException{
        String expectedPlaylistDeletedMessage = "Deleted playlist \"Best2023.\"";
        provideEmail("constantin@moraresco.com");
        providePassword("Nastika20$");
        clickSubmit();
        choosePlaylist();
        clickDeletePlaylistBtn();
        Assert.assertEquals(getDeletedPlaylistMsg(), expectedPlaylistDeletedMessage);
    }

    public String getDeletedPlaylistMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();

    }

    private void clickDeletePlaylistBtn() throws InterruptedException {
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
       // WebElement deletePlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylist.click();
        //Thread.sleep(2000);
    }

    public void choosePlaylist() throws InterruptedException{
        WebElement Playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"#!/playlist/90807\"]")));
        //WebElement Playlist = driver.findElement(By.xpath("//a[@href=\"#!/playlist/90805\"]"));
        Playlist.click();
        //Thread.sleep(2000);

    }
}
