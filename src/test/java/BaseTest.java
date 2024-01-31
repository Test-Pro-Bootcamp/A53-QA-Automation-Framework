import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    protected WebDriver driver;
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    protected WebDriverWait wait;
    protected Actions actions;

    @BeforeSuite
    static void setupClass() {
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {

        threadDriver.set(pickBrowser(System.getProperty("browser")));
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        actions = new Actions(getDriver());

        getDriver().get(BaseURL);
    }
    public static WebDriver getDriver() {
        return threadDriver.get();
    }
    public void tearDown() {
        threadDriver.get().close();// close browser
        threadDriver.remove();
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.162:4444/";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);

            case "grid-firefox": // gradle clean test -Dbrowser=grid-firefox
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-chrome": // gradle clean test -Dbrowser=grid-chrome
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "cloud":
                return lamdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptionsDefault = new ChromeOptions();
                chromeOptionsDefault.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptionsDefault);
        }
    }

    public WebDriver lamdaTest() throws MalformedURLException{
        String hubURL = "https://hub.lambdatest.com/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();

//        ChromeOptions browserOptions = new ChromeOptions();
//        browserOptions.setPlatformName("Windows 11");
//        browserOptions.setBrowserVersion("121.0");

        capabilities.setCapability("browserName","chrome");
        capabilities.setCapability("browserVersion","120.0");

        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "mattaktas94");
        ltOptions.put("accessKey", "L6Y6EmtaLwRlTt4xkKCqLAslbQXEIVnQJLJZUrlV0WMOGMtsX5");
        ltOptions.put("geoLocation", "US");
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("project", "Untitled");
        ltOptions.put("name", "Demo Test");
        ltOptions.put("selenium_version", "4.5.0");
        ltOptions.put("driver_version", "121.0");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-java");
//        browserOptions.setCapability("LT:Options", ltOptions);
        capabilities.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), capabilities);
    }
}
//Selenium Grid
//Running Commnet
//java -jar selenium-server-4.16.1.jar standalone