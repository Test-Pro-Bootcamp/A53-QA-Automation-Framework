import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException{
        String expectedPlaylistDeletedMessage = "deleted playlist \"TestPro Playlist.\"";

        provideEmail("demo@class.com");
        Thread.sleep(2000);
        providePassword("te$t$tudent");
        Thread.sleep(2000);
        clickSubmit();
        Thread.sleep(2000);
        openPlaylist();
        Thread.sleep(2000);
        clickDeletePlaylistBtn();
        Thread.sleep(2000);

        //Assertions
        Assert.assertEquals(getDeleteMessage(), expectedPlaylistDeletedMessage);


    }

    public void clickDeletePlaylistBtn() {
        WebElement deletePlaylist = wait. until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
     deletePlaylist.click();
    }

    public void openPlaylist() {
        WebElement emptyPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        emptyPlaylist.click();
    }
    public String getDeleteMessage() {
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();
    }


}
