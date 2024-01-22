import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest{

    @Test
    public void renamePlaylist() throws InterruptedException{
    //public void renamePlaylist(){

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        BasePage basePage = new BasePage(driver);
        String updatePlaylistMsg = "Updated playlist \"Sample Edited Playlist.\"";
        String newPlaylistName = "Sample Edited Playlist";

        loginPage.login();
        //Thread.sleep(2000);
        basePage.doubleClickPlaylistElement(By.cssSelector(".playlist:nth-child(3)"));
        //Thread.sleep(2000);
        homePage.enterNewPlaylistName(newPlaylistName, By.cssSelector("[name='name']"));
        //Thread.sleep(2000);
        //Assertions
        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(By.cssSelector("div.success.show")), updatePlaylistMsg);

    }
}
