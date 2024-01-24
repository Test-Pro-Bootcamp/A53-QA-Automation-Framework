import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;

public class Homework23Test extends BaseTest {

    @Test
    public void deletePlaylist() {
       LoginPage loginPage = new LoginPage(getThreadLocal());
       loginPage.loginUsertoKoel();

       HomePage homePage = new HomePage(getThreadLocal());
       homePage.selectPlaylistElement();
       homePage.clickDeletePlaylistBtn();
       homePage.getSuccessNotification();
       Assert.assertTrue(homePage.isSuccessNotificationActive);
       Assert.assertEquals(homePage.successNotificationText,"Deleted playlist \"NewPlaylist.\"");
    }

}