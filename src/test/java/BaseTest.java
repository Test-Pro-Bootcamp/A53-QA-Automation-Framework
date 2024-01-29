import Pages.HomePage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

//    //Page Object
//    LoginPage loginPage = new LoginPage(driver);
//    HomePage homePage = new HomePage(driver);

    public WebDriver driver;
//    public WebDriver driver2;

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public WebDriverWait wait;

    public String url = "https://qa.koel.app/";

    public Actions actions;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void lauchBrowser(String BaseUrl) throws MalformedURLException {
        //Chrome Options
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");

        //Manage Browser - wait for 10 seconds before failing/quitting
//        driver = new ChromeDriver(options);
    //    driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(pickBrowser(System.getProperty("browser")));

    //    driver2 = pickBrowser(System.getProperty("browser"));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    //    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//       driver.manage().window().maximize();

    //    actions = new Actions(driver);
        actions = new Actions(getDriver());

        //Navigate to Url
        url = BaseUrl;
        navigatorUrl();
    }

    public static WebDriver getDriver(){
        return threadDriver.get();
    }

    @AfterMethod
    public void tearDown(){
        threadDriver.get().close();
        threadDriver.remove();
    }

//    @AfterMethod
//    public void closeBrowser(){
//        driver.quit();
//    }


    void provideEmail(String email){
        //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }
    //"demo@class.com"

    void providePassword(String password){
        //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    //"te$t$tudent"

    void clickSubmit(){
        //WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitButton.click();
    }

    //Helper Method
    public void navigatorUrl(){
//        driver.get(url);
        getDriver().get(url);
    }

    /*
    *Test Script using Page Object Model.
    *Locators used in these test were located using By abstract class.
    */

/*
    @Test
    public void loginWithCorrectCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
//        loginPage.provideEmail("demo@class.com");
//        loginPage.providePassword("te$t$tudent");
//        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }
    @Test
    public void loginWithIncorrectCredentials() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);


        loginPage.provideEmail("demo1@class.com");
        loginPage.providePassword("te$t$tudent1");
        loginPage.clickSubmit();

        //Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),url);
//        try {
//            Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
//        }catch(NoSuchElementException e){
//            System.out.println("Element not displayed as expected");
//        }
    }
*/
    public WebDriver pickBrowser(String browser) throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        String gridUrl = "http://192.168.0.16:4444/";

        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--remote-allow-origins=*");
                return driver = new FirefoxDriver(firefoxOptions);

            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions= new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);

            case "grid-edge": //gradle clean test -Dbrowser=grid-edge
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);

            case "grid-firefox": //gradle clean test -Dbrowser=grid-firefox
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);

            case "grid-chrome": //gradle clean test -Dbrowser=grid-chrome
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);

            case "cloud":    //gradle clean test -Dbrowser=grid-cloud
                return lambDaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
        }
    }

    public WebDriver lambDaTest() throws MalformedURLException{
        String hubUrl = "https://hun.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();

//        ChromeOptions browserOptions = new ChromeOptions();
//        browserOptions.setPlatformName("Windows 11");
//        browserOptions.setBrowserVersion("121.0");

        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "121.0");

        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "magiclogiclu");
        ltOptions.put("accessKey", "JLZPlaaZpjpkOofHN9yfGXrCXUO0GkRWCaX854MPEyjHawNwNv");
        ltOptions.put("geoLocation", "CA");
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.5.0");
        ltOptions.put("driver_version", "121.0");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
//        browserOptions.setCapability("LT:Options", ltOptions);
        capabilities.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubUrl), capabilities);
    }

}