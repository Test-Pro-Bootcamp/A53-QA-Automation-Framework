package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;

    WebDriverWait wait;

    Actions actions;

    public BasePage(WebDriver giverDriver){
        driver = giverDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement findElementUsingByLocator(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }
    public void waitClick(WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void doubleClickPlaylistElement(By locator){
        actions.doubleClick(findElementUsingByLocator(locator)).perform();
        //actions.doubleClick(findElementUsingByLocator(playlistElement)).perform();
        System.out.println("Button is double clicked");
    }

    //allSongs
    public boolean isSongPlaying(){
        WebElement soundBarVisualizer = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        return soundBarVisualizer.isDisplayed();
    }

}
