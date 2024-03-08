package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.time.Duration;
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverWait waitQuick;
    protected Actions actions;

    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        waitQuick = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    protected WebElement findElement(WebElement webElement){
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected WebElement findElementQuick(WebElement webElement){
        return waitQuick.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected boolean findElementDisappear(WebElement webElement){
        return wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    protected void click(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement)).click();
    }

    protected void doubleClick(WebElement webElement){
        actions.doubleClick(findElement(webElement)).perform();
    }

    public String getActualPageUrl(){
        return driver.getCurrentUrl();
    }

}
