import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedPlayListDeletedMessage = "Deleted playlist \"Dark Days.\"";
        navigateToUrl(url);
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        clickPlaylistsGrid();
        clickDeletePlaylistBtn("TestPro PlayList.");

        String expectedPlaylistDeletedMessage = null;
        Assert.assertEquals(getDeletePlaylistSuccessMsg(), expectedPlaylistDeletedMessage);

    }

    public void clickPlaylistsGrid() throws InterruptedException {
        WebElement viewAll = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), \"Dark Days.\")]")));
        //WebElement viewAll = driver.findElement(By.xpath("//a[contains(text(), \"Homework17\")]"));
        viewAll.click();
        //Thread.sleep(2000);
    }

    public void clickDeletePlaylistBtn(String name) throws InterruptedException {
        WebElement playlistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='del btn-delete-playlist']")));
        //WebElement playlistBtn = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
        playlistBtn.click();
        //Thread.sleep(2000);
    }

    public String getDeletePlaylistSuccessMsg() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        //WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();


    }
}
