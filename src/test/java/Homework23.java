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

        //loginPage.login();

        navigateToPage();
        provideEmail("john.wolschleger@testpro.io");
        providePassword("te$t$tudentb49");
        clickSubmit();
        homePage.clickPlaylistsGrid();
        homePage.clickDeletePlaylistBtn();

        Assert.assertEquals(homePage.getDeletePlaylistSuccessMsg(), expectedPlaylistDeletedMessage);
    }
}