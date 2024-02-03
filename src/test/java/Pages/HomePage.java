package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    @FindBy(css = "[type='search']")
    private WebElement searchFieldLocator;
    @FindBy(css = "i[class='fa fa-plus-circle create']")
    private WebElement plusIcon;
    @FindBy(css = "li[data-testid='playlist-context-menu-create-simple']")
    private WebElement newPlaylistButton;
    @FindBy(css = "input[name='name']")
    private WebElement playlistInputField;
    @FindBy(css = "div.alertify-logs.top.right")
    private WebElement playlistCreatedMessageLocator;
    @FindBy(css = "div.success.show")
    private WebElement successNotification;

    @FindBy(css = ".btn-delete-playlist")
    private WebElement deletePlaylistBtn;



    //Page Elements
    By userAvatarIcon = By.cssSelector("img.avatar");

    By allSongsList = By.cssSelector("li a.songs");
    By byViewAllSearchButton = By.cssSelector("button[data-test='view-all-songs-btn']");
    By byPlaylistCreatedMessageLocator= By.cssSelector("div.alertify-logs.top.right");
    By bysuccessNotification = By.cssSelector("div.success.show");

    //Page Methods
    public WebElement getUserAvatarIcon(){
        return findElementUsingByLocator(userAvatarIcon);
    }

    //Element Locator
    //By playlistInputField = By.cssSelector("[name='name']");
    //By notificationRenamePlaylistSuccessMsg = By.cssSelector("div.success.show");

    public void createPlaylist(String playlistName) {
        clickPlusIcon();
        clickNewPlaylistButton();
        createAPlaylistName(playlistName);
    }
    public void clickPlusIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(plusIcon)).click();
    }

    public void clickNewPlaylistButton() {
        wait.until(ExpectedConditions.elementToBeClickable(newPlaylistButton)).click();
    }
    public void createAPlaylistName(String playlistName) {
        wait.until(ExpectedConditions.elementToBeClickable(playlistInputField)).sendKeys(playlistName);
        playlistInputField.submit();
    }
    public boolean isPlaylistCreatedMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byPlaylistCreatedMessageLocator));
        return playlistCreatedMessageLocator.isDisplayed();
    }

    public void choosePlaylistByName(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//ul//li//a[contains(text(), '" + playlistName + "')]"))).click();
        //System.out.println("chosen playlist clicked");
    }

    public WebElement doubleClickChoosePlaylistByName(String playlistName) {

        WebElement playlistElement = driver.findElement(By.xpath("//section[@id='playlists']//ul//li//a[contains(text(), '" + playlistName + "')]"));
        actions.doubleClick(playlistElement).perform();
        return driver.findElement(By.xpath("//section[@id='playlists']//ul//li//a[contains(text(), '" + playlistName + "')]"));
    }

    public void enterNewPlaylistName(String newName, By locator){
//        WebElement playlistInputField =
//                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        //clear does not work since element has an attribute of required.
        findElementUsingByLocator(locator).sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        findElementUsingByLocator(locator).sendKeys(newName);
        findElementUsingByLocator(locator).sendKeys(Keys.ENTER);
        //System.out.println("New Playlist name is entered");
    }
    public String getRenamePlaylistSuccessMsg(By locator){
        return findElementUsingByLocator(locator).getText();
    }
    public boolean playlistRenamedMsgIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bysuccessNotification));
        return successNotification.isDisplayed();
    }

    public void openPlaylistToDelete(){
        WebElement emptyPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//li[5]")));
        emptyPlaylist.click();
    }
    public void clickDeletePlaylistBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(deletePlaylistBtn)).click();
    }
//    public String getDeleteMessage(){
//        return findElementUsingByLocator(bysuccessNotification).getText();
//    }
    public boolean isplaylistDeleted() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bysuccessNotification));
        return successNotification.isDisplayed();
    }

    //allSongs
    public WebElement allSongsList(){
        return findElementUsingByLocator(allSongsList);
    }
    public void goToAllSongsList(){
        findElementUsingByLocator(allSongsList).click();
    }

    public WebElement hoverPlay(){
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(playBtn).perform();
        return wait.until(ExpectedConditions.visibilityOf(playBtn));
    }
    public void searchSong(String songName){
        wait.until(ExpectedConditions.elementToBeClickable(searchFieldLocator)).click();
        searchFieldLocator.sendKeys(songName);
    }
    public void viewAllSearchResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byViewAllSearchButton)).click();
    }



}
