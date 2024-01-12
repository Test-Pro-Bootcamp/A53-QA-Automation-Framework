import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework23 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {

        String expectedPlaylistDeletedMessage = "Deleted playlist \"Homework17.\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("john.wolschleger@testpro.io");
        loginPage.providePassword("te$t$tudentb49");
        loginPage.clickSubmit();
        homePage.clickPlaylistsGrid();
        homePage.clickDeletePlaylistBtn();

        Assert.assertEquals(homePage.getDeletePlaylistSuccessMsg(), expectedPlaylistDeletedMessage);
    }
}