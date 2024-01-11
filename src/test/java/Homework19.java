import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Parameters({"BaseUrl"})
    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedPlaylistDeletedMessage = "deleted playlist \"aplaylisyt.\"";

        provideEmail("azahn007@gmail.com");
        providePassword("Koelpass");
        clickSubmit();
        selectPlaylist();
        deletePlaylistBtn();



    }


    public void selectPlaylist() {
        WebElement playlist = driver.findElement(By.cssSelector("[href='#!/playlist/83406']"));
        playlist.click();
    }


    public void deletePlaylistBtn() {
        WebElement deletePlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylist.click();

    }
    public String getDeletedPlaylistMessage(){
        WebElement notificationmsg= driver.findElement(By.cssSelector("div.success.show"));;
        return notificationmsg.getText();
    }

}
