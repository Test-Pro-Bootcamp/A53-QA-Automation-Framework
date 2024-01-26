import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException{
        String expectedPlaylistDeletedMessage = "Deleted playlist \"TestPro Playlist.\"";

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        openPlayList();
        clickDeletePlaylistBtn();
        //Assertion
        Assert.assertEquals(getDeletedPlaylistMsg(),expectedPlaylistDeletedMessage);

    }

    public void clickDeletePlaylistBtn() {
        WebElement deletePlaylist = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
        deletePlaylist.click();
    }

    public void openPlayList() {
        //WebElement emptyPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//li[9]")));
        WebElement emptyPlaylist = fluentWait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("//section[@id='playlists']//li[9]")));
        emptyPlaylist.click();
    }

    public String getDeletedPlaylistMsg(){
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        //WebElement notificationMsg = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        //return notificationmsg.getText();
        return notificationMsg.getText();
    }



}
