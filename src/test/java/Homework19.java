import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.Test;
import webElement.webElement;
import static java.lang.Thread.*;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlayList() throws InterruptedException {
        String expectedPlayListDeletedMessage = "Deleted playlist \"TestPro PlayList.\"";
        navigateToUrl(url);
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        openPlayList();
        clickDeletePlaylistBtn();
        //Assertions

        String expectedPlaylistDeletedMessage = null;
        Assert.assertEquals(getDeletedPlaylistMsg(), expectedPlayListDeletedMessage);
    }

    public void openPlayList() {
        WebElement emptyPlayList = driver.findElement(By.xpath("//selection[@id='playLists']li[6]"));
        webElement emptyPlaylist;
        emptyPlayList.click();

    }

    public void clickDeletePlaylistBtn() {
        WebElement deletePlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylist.click();

    }

    public String getDeletedPlaylistMsg() {
        WebElement notificationmsg = driver.findElement(By.cssSelector("div.success.show"));
        return notificationmsg.getText();
    }
}






