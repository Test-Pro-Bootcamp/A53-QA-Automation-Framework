package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SongsPage extends BasePage {

    @FindBy (xpath= "//a[@href='#!/songs']")
    protected WebElement allSongslink;
    @FindBy (xpath= "//*[@id='songsWrapper']//tr[@class='song-item'][1]")
    protected WebElement firstSongResultElement;
    @FindBy (xpath= "//*[@id='songsWrapper']//tr[@class='song-item'][2]")
    protected WebElement secondSongResultElement;
    @FindBy (xpath= "//*[@id='songsWrapper']//tr[@class='song-item'][3]")
    protected WebElement thirdSongResultElement;
    @FindBy (xpath= "//button[@class='btn-add-to']")
    protected WebElement addToQueueBtn;
    @FindBy (xpath= "//*[@id='songsWrapper']//li[@class='bottom-queue']")
    protected WebElement bottomQueueMenuItem;
    @FindBy (xpath="//a[@href='#!/queue']")
    protected WebElement queueLink;
    @FindBy (xpath= "//*[@id='queueWrapper']//tr[@class='song-item'][1]")
    protected WebElement firstQueueResultElement;
    @FindBy (xpath= "//i[@data-testid='play-next-btn']")
    protected WebElement playNextBtn;
    @FindBy (xpath= "//*[@data-testid='sound-bar-play']")
    protected WebElement soundBarPlayElement;
    @FindBy (xpath= "//button[@class='btn-shuffle-all']")
    protected WebElement shuffleAllBtn;
    public SongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public SongsPage addSongsToQueue(){
        loadAllSongsPage();
        selectSongsFirstElement();
        clickAddToQueue();
        selectBottomQueueMenuItem();
        selectSongsSecondElement();
        clickAddToQueue();
        selectBottomQueueMenuItem();
        return this;
    }

    public SongsPage addThreeSongsToQueue(){
        loadAllSongsPage();
        selectSongsFirstElement();
        clickAddToQueue();
        selectBottomQueueMenuItem();
        selectSongsSecondElement();
        clickAddToQueue();
        selectBottomQueueMenuItem();
        selectSongsThirdElement();
        clickAddToQueue();
        selectBottomQueueMenuItem();
        return this;
    }
    public SongsPage loadAllSongsPage(){
        allSongslink.click();
        return this;
    }
    public SongsPage selectSongsFirstElement(){
        firstSongResultElement.click();
        return this;
    }

    public SongsPage playSongsFirstElement(){
        doubleClick(firstSongResultElement);
        return this;
    }
    public SongsPage selectSongsSecondElement(){
        secondSongResultElement.click();
        return this;
    }
    public SongsPage selectSongsThirdElement(){
        thirdSongResultElement.click();
        return this;
    }
    public SongsPage selectShuffleAllBtn(){
        shuffleAllBtn.click();
        return this;
    }
    public SongsPage clickAddToQueue(){
        addToQueueBtn.click();
        return this;
    }
    public SongsPage selectBottomQueueMenuItem(){
        bottomQueueMenuItem.click();
        return this;
    }

}
