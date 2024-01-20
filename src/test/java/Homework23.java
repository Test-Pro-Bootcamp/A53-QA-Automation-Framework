import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework23 extends BaseTest{

    @Test
    public void deletePlaylist() {
        String expectedPlaylistDeletedMessage = "Deleted playlist \"Delete Me!.\"";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //Steps
        loginPage.provideEmail("Andrew.Simmons@testpro.io");
        loginPage.providePassword("Andrew.Simmons24");
        loginPage.clickSubmit();

        homePage.clickPlaylistToDelete()
                .clickDeletePlaylist();

        String actualPlaylistDeletedMessage = String.valueOf(homePage.getDeletedPlaylistMsg());

        Assert.assertEquals(homePage.getDeletedPlaylistMsg(), "Deleted playlist \"Delete Me!.\"");


    }

    /*public String getDeletedPlaylistMsg(){
        WebElement deleteNotification = driver.findElement(By.cssSelector(".success.show"));
        return deleteNotification.getText();
    }*/

}
