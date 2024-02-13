package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "#playlists ul li:nth-child(3)")
    WebElement playlistToDelete;

    @FindBy(css = "button[class='del btn-delete-playlist']")
    WebElement deletePlaylistButton;

    @FindBy(css = "div.success.show")
    WebElement successMessage;

    @FindBy(css = "img.avatar")
    WebElement userAvatarIcon ;

    public HomePage clickPlaylistToDelete() {
        playlistToDelete.click();
        return this;

    }

    public HomePage clickDeletePlaylist() {
        deletePlaylistButton.click();
        return this;
    }


    public String getDeletedPlaylistMsg() {
        return successMessage.getText();
    }
    //Page Locators


    public WebElement getUserAvatarIcon (){
        return findElementUsingByLocator(userAvatarIcon);
    }
    public void doubleClickPlaylist(){
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
        System.out.println("double clicked on playlist.");
    }
    public void enterNewPlaylistName(String newPlaylistName){
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        System.out.println("Playlist Located.");
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public String getRenamePlaylistSuccessMsg() {
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();

    }
}