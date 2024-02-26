package PageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class commonUtils {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Parameters({"BaseUrl"})
    @BeforeClass

    public void setUpDriver(String BaseUrl) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(BaseUrl); // Navigating WebDriver to the specified URL
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

    public void elementToBeClickable(WebElement element) throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void elementToBeVisible(WebElement element) throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void elementToDisappear(String  element) throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element)));
    }

    public void clickElement(WebElement element) throws Throwable{
        elementToBeClickable(element);
        element.click();
    }

    public void typeValueInElement(WebElement element, String value) throws Throwable{
        elementToBeClickable(element);
        element.sendKeys(value);
    }
    public void doubleClick(WebElement element) throws Throwable {
        Actions mouse = new Actions(driver);
        elementToBeClickable(element);
        mouse.doubleClick(element).build().perform();
    }
}