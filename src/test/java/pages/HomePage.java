package pages;
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


    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement playlistElement;

    @FindBy(css = "[name='name']")
    private WebElement playlistInputField;

    @FindBy(css = "div.success.show")
    private WebElement notificationMsg;

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
        wait.until(ExpectedConditions.visibilityOf(playlistElement));
        actions.doubleClick(playlistElement).perform();
        System.out.println("double clicked on playlist.");
    }

    public void enterNewPlaylistName(String newPlaylistName){
        wait.until(ExpectedConditions.visibilityOf(playlistInputField));
        System.out.println("Playlist Located.");
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg() {
        wait.until(ExpectedConditions.visibilityOf(notificationMsg));
        return notificationMsg.getText();
    }


}