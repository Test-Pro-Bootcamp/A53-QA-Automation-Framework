import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import java.time.Duration;

public class Homework23Test extends BaseTest {

    @Test
    public void deletePlaylist() {
       LoginPage loginPage = new LoginPage(driver);
       loginPage.loginUsertoKoel();

       HomePage homePage = new HomePage(driver);
       homePage.selectPlaylistElement();
       homePage.clickDeletePlaylistBtn();
       homePage.getSuccessNotification();
       Assert.assertTrue(homePage.isSuccessNotificationActive);
       Assert.assertEquals(homePage.successNotificationText,"Deleted playlist \"NewPlaylist.\"");
    }

}