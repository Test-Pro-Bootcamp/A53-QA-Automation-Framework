import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    String newPlaylistName = "Homework21";

@Test
public void renamePlaylist() throws InterruptedException {

    String updatedPlaylistMsg = "Updated playlist \"Homework21.\"";

    navigateToPage();
    provideEmail("john.wolschleger@testpro.io");
    providePassword("te$t$tudentb49");
    clickSubmit();
    doubleClickPlaylist();
    enterNewPlaylistName();
    Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);
}

public void doubleClickPlaylist() {
    WebElement playlistElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Homework17')]")));
    Actions actions = new Actions(driver);
    actions.doubleClick(playlistElement).perform();
}

public void enterNewPlaylistName() {
    WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
    playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"A", Keys.BACK_SPACE));

    playlistInputField.sendKeys(newPlaylistName);
    playlistInputField.sendKeys(Keys.ENTER);
}

public String getRenamePlaylistSuccessMsg(){
    WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
    return notification.getText();
  }
}