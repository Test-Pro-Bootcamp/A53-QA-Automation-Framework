import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException {

        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.provideLoginSucceed();


        //Select the Playlist Titled "Delete Me"
        WebElement playlist = getThreadLocal().findElement(By.cssSelector("#playlists ul li:nth-child(3)"));
        playlist.click();

        //Select the Delete Playlist Button
        WebElement deleteButton = getThreadLocal().findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        deleteButton.click();

        Assert.assertEquals(getDeletedPlaylistMsg(), "Deleted playlist \"Delete Me!.\"");


    }

    public String getDeletedPlaylistMsg(){
        WebElement deleteNotification = getThreadLocal().findElement(By.cssSelector(".success.show"));
        return deleteNotification.getText();
    }

}