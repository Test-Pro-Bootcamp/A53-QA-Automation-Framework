import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework23 extends BaseTest {

    @Test
    public void deletePlaylist() {
        String expectedPlaylistDeletedMessage = "Deleted playlist \"Delete Me!.\"";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //Steps
        loginPage.provideEmail("dmitry.lobachev@testpro.io");
        loginPage.providePassword("Chebyreki5!");
        loginPage.clickSubmitBtn();

        homePage.clickPlaylistToDelete()
                .clickDeletePlaylist();

        String actualPlaylistDeletedMessage = String.valueOf(homePage.getDeletedPlaylistMsg());

        Assert.assertEquals(homePage.getDeletedPlaylistMsg(), "Deleted playlist \"Delete Me!.\"");


    }

}
