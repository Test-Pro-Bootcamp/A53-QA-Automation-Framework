import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException {

        navigateToPage();
        provideEmail("dmitry.lobachev@testpro.io");
        providePassword("Chebyreki5!");
        clickSubmit();
        Thread.sleep(2000);


        //Select the Playlist Titled "Delete Me"
        WebElement playlist = driver.findElement(By.cssSelector("#playlists ul li:nth-child(3)"));
        playlist.click();

        //Select the Delete Playlist Button
        WebElement deleteButton = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        deleteButton.click();


        Assert.assertEquals(getDeletedPlaylistMsg(), "Deleted playlist \"Delete Me!.\"");


    }

    public String getDeletedPlaylistMsg(){
        WebElement deleteNotification = driver.findElement(By.cssSelector(".success.show"));
        return deleteNotification.getText();
    }

}