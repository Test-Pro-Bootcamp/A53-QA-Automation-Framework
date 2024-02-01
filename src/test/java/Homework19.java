import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() {
        String expectedPlaylistDeletedMessage = "Deleted playlist \"TestPro Playlist.\"";

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        openPlaylist();
        clickDeletePlaylistBtn();

        //Assertions
        Assert.assertEquals(getDeleteMessage(), expectedPlaylistDeletedMessage);

    }

    public void clickDeletePlaylistBtn() {
        WebElement deletePlaylist = wait. until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
     deletePlaylist.click();
    }

    public void openPlaylist() {
        //WebElement emptyPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(4)")));
        WebElement emptyPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//li[7]")));
        emptyPlaylist.click();

    }
    public String getDeleteMessage() {
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();
    }


}
