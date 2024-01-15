import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class PlaylistTests extends BaseTest {

    @Test
    public void deletePlaylistTest() {

        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmail("john.wolschleger@testpro.io");
        loginPage.providePassword("te$t$tudentb49");
        loginPage.clickSubmit();

        homePage.clickPlaylistsGrid();
        homePage.clickDeletePlaylistBtn();

        String expectedPlaylistDeletedMessage = "Deleted playlist \"Homework17.\"";
        Assert.assertEquals(homePage.getDeletePlaylistSuccessMsg(), expectedPlaylistDeletedMessage);

    }
}