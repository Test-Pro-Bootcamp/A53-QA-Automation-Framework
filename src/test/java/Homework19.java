import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletPlayelist() throws InterruptedException{
        Thread.sleep(2000);
        provideEmail("demo@class.com");
        Thread.sleep(2000);
        providePassword("te$t$tudent");
        Thread.sleep(2000);
        clickSubmit();

        openPlaylist();
        Thread.sleep(2000);
        clickDeletePlaylistBtn();


        String expectedDeletePlaylistMessage = "Deleted playlist \"Test Pro Playlist.\"";
        Assert.assertEquals(getDeleteMessage(), expectedDeletePlaylistMessage);

    }

    public void openPlaylist(){
        //WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        WebElement emptyPlaylist = driver.findElement(By.xpath("//section[@id='playlists']//li[7]"));
        emptyPlaylist.click();
    }
    public void clickDeletePlaylistBtn() throws InterruptedException{
        WebElement deletePlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylist.click();
        Thread.sleep(2000);
    }
    public String getDeleteMessage(){
        WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
        return notificationMsg.getText();
    }


}
