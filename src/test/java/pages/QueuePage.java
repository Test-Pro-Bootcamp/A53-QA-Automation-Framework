package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


public class QueuePage extends BasePage {

    @FindBy (xpath="//a[@href='#!/queue']")
    protected WebElement queueLink;
    @FindBy (xpath= "//*[@id='queueWrapper']//tr[@class='song-item'][1]")
    protected WebElement firstQueueResultElement;
    @FindBy (xpath= "//i[@data-testid='play-next-btn']")
    protected WebElement playNextBtn;
    @FindBy (xpath= "//*[@data-testid='sound-bar-play']")
    protected WebElement soundBarPlayElement;

    @FindBy (xpath= "//*[@id='queueWrapper']//td[@class='title']")
    protected WebElement songTitleQueue;

    @FindBy (xpath= "//span[@data-test='list-meta']")
    protected WebElement songCount;

    @FindBy (xpath= "//span[@data-test='list-meta']")
    protected WebElement totalSongDuration;

    @FindBy (xpath= "//*[@id='queueWrapper']//td[@class='artist']")
    protected WebElement songArtist;
    @FindBy (xpath= "//*[@id='queueWrapper']//td[@class='time text-secondary']")
    protected WebElement songTime;
    @FindBy (xpath= "//*[@id='queueWrapper']//td[@class='album']")
    protected WebElement songAlbum;
    @FindBy (xpath= "//*[@id='queueWrapper']//td[@class='track-number text-secondary']")
    protected WebElement songId;
    @FindBy (xpath= "//button[@class='btn-shuffle-all']")
    protected WebElement shuffleAllBtn;
    @FindBy (xpath= "//button[@class='btn-clear-queue']")
    protected WebElement clearQueueBtn;
    @FindBy (xpath= "//a[@class='start']")
    protected WebElement startShufflingLink;
    @FindBy (xpath= "//div[contains(text(),'No songs queued')]")
    protected WebElement noSongsQueuedMsg;



    public QueuePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public QueuePage loadQueuePage(){
        queueLink.click();
        return this;
    }

    public QueuePage selectFirstSongQueue(){
        doubleClick(firstQueueResultElement);
        return this;
    }

    public QueuePage clickPlayNext(){
        playNextBtn.click();
        return this;
    }
    public QueuePage clickShuffleAllBtn(){
        shuffleAllBtn.click();
        return this;
    }
    public QueuePage clickClearQueueBtn(){
        clearQueueBtn.click();
        return this;
    }
    public QueuePage clickStartShufflingLink(){
        startShufflingLink.click();
        return this;
    }

    public String getFirstSongTitle(){
        return songTitleQueue.getText();
    }
    public boolean isNoSongQueuedMsg(){
        return noSongsQueuedMsg.isDisplayed();
    }

    public String getSongCount() {
        return songCount.getText();
    }

    public String getTotalSongDuration(){
        return totalSongDuration.getText();
    }

    public String getFirstSongArtist(){
        return songArtist.getText();
    }
    public String getFirstSongAlbum(){
        return songAlbum.getText();
    }
    public String getFirstSongDuration(){
        return songTime.getText();
    }

    public boolean getFirstSongID(){
        return songId.isDisplayed();
    }
    public boolean checkShuffling(String songTitle){
        shuffleAllBtn.click();
        boolean result = !songTitle.equals(getFirstSongTitle());
        if(!result){
            shuffleAllBtn.click();
            result = !songTitle.equals(getFirstSongTitle());
                if(!result){
                shuffleAllBtn.click();
                result = !songTitle.equals(getFirstSongTitle());
                }
        }
        return result;
    }

    public boolean soundBarIsDisplayed(){
        try {
            WebElement soundBarPlayElementWait = findElement(soundBarPlayElement);
            return soundBarPlayElementWait.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e){
            return false;
        }
    }

}
