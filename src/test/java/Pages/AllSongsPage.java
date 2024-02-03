package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AllSongsPage extends BasePage{

    public AllSongsPage(WebDriver givenDriver){super(givenDriver);}

    @FindBy(css ="button.btn-add-to" )
    private WebElement addSelectedSong;
    @FindBy(xpath = "//*[@id='songsWrapper']/header/div[3]/div/section[1]/ul/li[5]")
    private WebElement selectCreatedPlaylist;
    @FindBy(css = "div.alertify-logs.top.right")
    private WebElement songAddedMessageLocator;



    By firstSongInAllSongs = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
    By playBtnContextMenu = By.cssSelector("li.playback");
    By songAddedNotification= By.cssSelector("div.alertify-logs.top.right");


    public WebElement firstSongInAllSongs(){
        return findElementUsingByLocator(firstSongInAllSongs);
    }
    public void contextClickFirstSong(){
        WebElement firstSongInTheList = wait.until(ExpectedConditions
                .visibilityOfElementLocated(firstSongInAllSongs));
        actions.contextClick(firstSongInTheList).perform();
        //actions.contextClick(findElementUsingByLocator(firstSongInAllSongs).perform();
    }
    public void choosePlayOption(){
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(playBtnContextMenu)).click();
    }
    public void addToButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addSelectedSong)).click();
    }
    public void selectExistPlayList() {
        wait.until(ExpectedConditions.elementToBeClickable(selectCreatedPlaylist)).click();
    }
    public boolean verifyAddSongToPlaylistMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(songAddedNotification));
        return songAddedMessageLocator.isDisplayed();
    }



}


//public void chooseAllSongsList(){
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
//}
//public void contextClickFirstSong(){
//    WebElement firstSongInTheList = wait.until(ExpectedConditions
//            .visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
//    actions.contextClick(firstSongInTheList).perform();
//}
//public void choosePlayOption(){
//    wait.until(ExpectedConditions
//                    .visibilityOfElementLocated(By.xpath("//nav[@class='menu song-menu']//ul//li[@class='playback']//span[1]")))
//            .click();
//
//    //        li.playback
//    //        //nav[@class='menu song-menu']//ul//li[@class="playback"]
//    //        //nav[@class='menu song-menu']//ul//li[@class='playback']//span[1]
//}
//public boolean isSongPlaying(){
//    WebElement soundBarVisualizer = wait.until(ExpectedConditions
//            .visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
//    return soundBarVisualizer.isDisplayed();
//}
//
//public WebElement hoverPlay(){
//    WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
//    actions.moveToElement(playBtn).perform();
//    return wait.until(ExpectedConditions.visibilityOf(playBtn));
//}
//
//public void choosePlaylistByName(String playlistName){
//    wait.until(ExpectedConditions
//                    .visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+playlistName+"')]")))
//            .click();
//    ////a[contains(text(),'Playlist to count songs')]
//}
//public int countSongs(){
//    return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
//}
//public String getPlaylistDetails(){
//    return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
//}
//public void displayAllSongs() throws InterruptedException{
//    Thread.sleep(2000);   //Test would not pass without this sleep
//    List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
//    System.out.println("Number of Songs found: " +countSongs());
//    for (WebElement e : songList){
//        System.out.println(e.getText());
//    }
//}
//
//public void doubleClickPlaylist(){
//    WebElement playlistElement =
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
//    actions.doubleClick(playlistElement).perform();
//}
//public void enterNewPlaylistName(){
//    WebElement playlistInputField =
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
//    //clear does not work since element has an attribute of required.
//    playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
//    playlistInputField.sendKeys(newPlaylistName);
//    playlistInputField.sendKeys(Keys.ENTER);
//}
//public String getRenamePlaylistSuccessMsg(){
//    WebElement notification =
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
//    return notification.getText();
//}
