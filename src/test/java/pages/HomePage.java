package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    @FindBy(xpath="//li[@class='playlist playlist'][1]")
    private WebElement playlistElement;
    @FindBy(xpath="//button[@class='del btn-delete-playlist']")
    private WebElement deletePlaylistBtn;
    @FindBy(xpath="//*[@class='success show']")
    private WebElement successNotification;
    @FindBy(xpath="//p[@class='msg']")
    private WebElement deleteNotification;
    @FindBy(xpath="//button[@class='ok']")
    private WebElement deleteNotificationOkBtn;
    @FindBy(xpath="//input[@type='search']")
    private WebElement searchBtn;
    @FindBy(xpath="//button[@data-test='view-all-songs-btn']")
    private WebElement viewAllSongsBtn;

    @FindBy(xpath="//*[@id='songResultsWrapper']//tr[@class='song-item']")
    private WebElement songResultSongItem;

    @FindBy(xpath="//button[@class='btn-add-to']")
    private WebElement addToBtn;

    @FindBy(xpath="//*[@id='songResultsWrapper']//li[@class='playlist']")
    private WebElement songResultPlaylist;

    @FindBy(xpath="//i[@data-testid='sidebar-create-playlist-btn']")
    private WebElement createPlaylistBtn;

    @FindBy(xpath="//li[@data-testid='playlist-context-menu-create-simple']")
    private WebElement newPlaylistMenuItem;

    @FindBy(xpath="//input[@name='name']")
    private WebElement newPlaylistTextBox;

    @FindBy(xpath="//li[contains(text(),'NewPlaylist')]")
    private WebElement playListElementNewPlaylist;

    @FindBy(xpath="//li[contains(text(),'RenamedPlaylist')]")
    private WebElement playListElementRenamedPlaylist;
    @FindBy(xpath="//input[@data-testid='inline-playlist-name-input']")
    private WebElement playListRenameTextField;

    @FindBy(xpath="//img[@class='avatar']")
    private WebElement avatarElement;

    @FindBy(xpath="//*[@data-testid='btn-logout']")
    private WebElement logoutBtn;

    public boolean isSuccessNotificationActive;
    public String successNotificationText;
    public boolean isDeletePlaylistNotification;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
        isSuccessNotificationActive = false;
        successNotificationText = " ";
    }

    public HomePage selectPlaylistElementNewPlaylist(){
        playListElementNewPlaylist.click();
        return this;
    }
    public boolean playListElementNewPlaylistDisplayed(){
       return playListElementNewPlaylist.isDisplayed();
    }

    public boolean avatarIsDisplayed(){
        try {
            WebElement avatarElementWait = findElement(avatarElement);
            return avatarElementWait.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e){
            return false;
        }
    }

    public HomePage selectPlaylistElementRenamedPlaylist(){
        playListElementRenamedPlaylist.click();
        return this;
    }

    public HomePage renamePlaylistElementNewPlaylist(String playlistName){
        doubleClick(playlistElement);
        WebElement playListRenameTextFieldWait = findElement(playListRenameTextField);
        playListRenameTextFieldWait.sendKeys(Keys.chord(Keys.COMMAND,"a",Keys.DELETE));
        playListRenameTextFieldWait.sendKeys(playlistName, Keys.ENTER);
        return this;
    }
    public HomePage selectPlaylistElement(String playlistName){
        if (playlistName.equals("RenamedPlaylist")){
            selectPlaylistElementRenamedPlaylist();
        } else {
            selectPlaylistElementNewPlaylist();
        }
        return this;
    }
    public HomePage selectPlaylistElement(){
       playlistElement.click();
        return this;
    }
    public HomePage clickDeletePlaylistBtn(){
        deletePlaylistBtn.click();
        return this;
    }
    public HomePage clickCreatePlaylistBtn(){
        WebElement createPlaylistBtnWait = findElement(createPlaylistBtn);
        createPlaylistBtnWait.click();
        return this;
    }
    public HomePage selectNewPlaylistMenuItem(){
        newPlaylistMenuItem.click();
        return this;
    }
    public HomePage clickDeleteNotificationOkBtn(){
        deleteNotificationOkBtn.click();
        getSuccessNotification();
        return this;
    }

    public HomePage searchSongPluto(){
        searchBtn.sendKeys("Pluto");
        return this;
    }

    public HomePage clickSearch(){
        searchBtn.click();
        return this;
    }

    public HomePage selectViewAllSongsBtn(){
        viewAllSongsBtn.click();
        return this;
    }

    public HomePage selectSong(){
      songResultSongItem.click();
        return this;
    }

    public HomePage selectAddToPlaylist(){
        addToBtn.click();
        return this;
    }

    public HomePage selectPlaylist(){
        songResultPlaylist.click();
        return this;
    }

    public HomePage logOut(){
        logoutBtn.click();
        return this;
    }

    public HomePage getDeleteNotification(){
        try {
            getSuccessNotification();
        }catch (TimeoutException | NoSuchElementException e){
            WebElement deleteNotificationWait = findElementQuick(deleteNotification);
            if (deleteNotificationWait.isDisplayed()) {
                clickDeleteNotificationOkBtn();
            }
        }
        return this;
    }

    public HomePage createNewPlaylist(){
        newPlaylistTextBox.sendKeys("NewPlaylist",Keys.ENTER);
        return this;
    }

    public HomePage getSuccessNotification(){
      WebElement successNotificationWait = findElement(successNotification);
        isSuccessNotificationActive = successNotificationWait.isDisplayed();
        successNotificationText = successNotificationWait.getText();
        return this;
    }
    public boolean waitForSuccessNotificationDisappear(){
        return findElementDisappear(successNotification);
    }

}
