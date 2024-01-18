import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork21 extends BaseTest{
    String newPlaylistName = "Test Pro 1";
    @Test
    public void renamePlaylist()  {
        String updatePlaylistMsg = "Updated playlist \"Test Pro 1.\"";

        loginToKoelApp();
        doubleClickPlaylist();
        enterNewPlaylistName();
        //Assertions
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatePlaylistMsg);
    }
        public void doubleClickPlaylist() {
            WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By
                    .cssSelector(".playlist:nth-child(10)")));
            actions.doubleClick(playlistElement).perform();
        }
        public void enterNewPlaylistName(){
            WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By
                    .cssSelector("[name='name']")));
            playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
            playlistInputField.sendKeys(newPlaylistName);
            playlistInputField.sendKeys(Keys.ENTER);
        }
        public String getRenamePlaylistSuccessMsg(){
            WebElement notificationMsg =  wait.until(ExpectedConditions.visibilityOfElementLocated(By
                    .cssSelector("div.success.show")));
            return notificationMsg.getText();
        }
}
