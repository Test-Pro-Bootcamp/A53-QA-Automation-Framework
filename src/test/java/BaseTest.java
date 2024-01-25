import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    //Data Providers
    @DataProvider(name="InvalidLoginData")
    public static Object[][] getDataFromDataProviders(){
        return new Object[][] {
                {"invalid@mail.com", "invalidPassword"},
                {"demo@class.com", ""},
                {"", "te$t$tudent"},
                {"",""}
        };
    }

    public WebDriver driver;
    public WebDriverWait wait;

    public Wait<WebDriver> fluentWait;

    public String url = "https://qa.koel.app/";

    public Actions actions;

    @BeforeSuite
    static void setupClass() {
        //WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @Parameters({"BaseUrl"})
    @BeforeMethod
    public void launchBrowser(String BaseUrl) throws MalformedURLException {
        //Chrome Options
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //Manage Browser - wait for 10 seconds before failing/quitting.
        driver = new ChromeDriver(options);*/
        //driver = new FirefoxDriver();
        driver = pickBrowser(System.getProperty("browser"));
        //Implicit Wait
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Explicit Wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Fluent Wait
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
                //.ignoring(NoAlertPresentException.class);
        actions = new Actions(driver);
        driver.manage().window().maximize();
        //String url = BaseUrl;
        //Navigate to Url
        navigateToUrl(BaseUrl);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    void providePassword(String password) {
        //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    void clickSubmit(){
        //WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submitButton.click();
    }

    //Helper Method
    public void navigateToUrl(String givenUrl){
        driver.get(givenUrl);
    }

    public void loginToKoelApp(){
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://10.0.0.206:4444/";
        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();

            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver();

            case "grid-edge": // gradle clean test -Dbrowser=grid-edge
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-firefox": // gradle clean test -Dbrowser=grid-firefox
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-chrome": // gradle clean test -Dbrowser=grid-chrome
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
        }
    }

}