import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
        @Test
        public void deletePlaylist() throws InterruptedException {

            String expectedPlaylistDeletedMessage = "Deleted playlist \"Homework17.\"";

            navigateToPage();
            provideEmail("john.wolschleger@testpro.io");
            providePassword("te$t$tudentb49");
            clickSubmit();
            Thread.sleep(2000);
            clickPlaylistsGrid();
            clickDeletePlaylistBtn("Homework17");
            Assert.assertEquals(getDeletePlaylistSuccessMsg(), expectedPlaylistDeletedMessage);
        }
    public void clickPlaylistsGrid() throws InterruptedException {
       WebElement viewAll = driver.findElement(By.xpath("//a[contains(text(), \"Homework17\")]"));
       viewAll.click();
       Thread.sleep(2000);
  }
    public void clickDeletePlaylistBtn(String name) throws InterruptedException {
       WebElement playlistBtn = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
       playlistBtn.click();
       Thread.sleep(2000);
    }
  public String getDeletePlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
      }
    }