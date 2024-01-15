import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{

    String newPlaylistName = "Sample Edited Playlist";
    @Test
    //public void renamePlaylist() throws InterruptedException{
    public void renamePlaylist() {
        String updatePlaylistMsg = "Updated playlist \"Sample Edited Playlist.\"";
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        //Thread.sleep(2000);

        doubleClickPlaylist();
        //Thread.sleep(2000);
        enterNewPlaylistName();
        //Thread.sleep(2000);
        //Assertions
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatePlaylistMsg);
    }

    public void doubleClickPlaylist(){
        WebElement playlistElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
        System.out.println("Button is double clicked");
    }
    public void enterNewPlaylistName(){
        WebElement playlistInputField =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        //clear does not work since element has an attribute of required.
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
        System.out.println("New Playlist name is entered");
    }
    public String getRenamePlaylistSuccessMsg(){
        WebElement notification =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

}
