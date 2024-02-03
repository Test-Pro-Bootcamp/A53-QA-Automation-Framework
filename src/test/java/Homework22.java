import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {

        String expectedPlaylistDeletedMessage = "Deleted playlist \"Homework21.\"";

        navigateToPage();
        provideEmail("ramya.gudur@testpro.io");
        providePassword("Ammananna@65");
        clickSubmit();
        clickPlaylistsGrid();
        clickDeletePlaylistBtn("Homework21");
        Assert.assertEquals(getDeletePlaylistSuccessMsg(), expectedPlaylistDeletedMessage);
    }
    public void clickPlaylistsGrid() throws InterruptedException {
        WebElement viewAll = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), \"Homework17\")]")));
        viewAll.click();
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

