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

    public boolean soundBarIsDisplayed(){
        try {
            WebElement soundBarPlayElementWait = findElement(soundBarPlayElement);
            return soundBarPlayElementWait.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e){
            return false;
        }
    }

}
