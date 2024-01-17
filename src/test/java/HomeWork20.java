import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork20 extends BaseTest{

        @Test
        public void deletePlaylist() throws InterruptedException{
            String expectedDeletedPlaylistMessage = "Deleted playlist \"Test Pro Playlist.\"";
            provideEmail("demo@class.com");
            providePassword("te$t$tudent");
            clickSubmit();
            openPlaylist();
            clickDeletePlaylistButton();
            //Assertion
            Assert.assertEquals(getDeletedPlaylistMsg(),expectedDeletedPlaylistMessage);
        }
        public void openPlaylist(){
            WebElement emptyPlaylist = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//section[@id='playlists']//li[4]")));
            //WebElement emptyPlaylist = driver.findElement(By.xpath("//section[@id='playlists']//li[4]"));
            emptyPlaylist.click();
        }
        public void clickDeletePlaylistButton(){
            WebElement deletePlaylist =  wait.until(ExpectedConditions
                            .visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
            //WebElement deletePlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
            deletePlaylist.click();
        }
        public String getDeletedPlaylistMsg(){
            WebElement notification = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.cssSelector("div.success.show")));
            //WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
            return notification.getText();
        }





}
