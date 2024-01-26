import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException{
        String expectedPlaylistDeletedMessage = "deleted playlist \"TestPro Playlist. \"";

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        openPlaylist();
        clickDeletePlaylistBtn();
        //Assertions


    }

    public void openPlaylist() {
        WebElement emptyPlaylist = wait.until(ExpectedCondition.)
    }
}
