package Pages;

import org.openqa.selenium.By;
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

   //Elements
    //By soundBarVisualizer = By.cssSelector("[data-testid='sound-bar-play']");
   By allSongsList = By.cssSelector("li a.songs");

   public BasePage(WebDriver givenDriver){
       driver = givenDriver;
       wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       actions = new Actions(driver);
       PageFactory.initElements(driver,this);

   }
   public WebElement findElementUsingByLocator(By locator){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

   }
   public void click (By locator) {
       findElementUsingByLocator(locator).click();
   }
   public void doubleClick (By locator) {
       actions.doubleClick(findElementUsingByLocator(locator)).perform();
   }

    public boolean isSongPlaying() throws InterruptedException {
        WebElement soundBarVisualizer = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        return soundBarVisualizer.isDisplayed();}

    public void goToAllSongsList(){
        findElementUsingByLocator(allSongsList).click();
    }


}

