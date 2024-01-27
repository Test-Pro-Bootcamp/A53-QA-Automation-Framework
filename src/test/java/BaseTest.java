import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

// Import necessary packages and classes for working with WebDriver,
// browser configurations, and executing automated tests using TestNG.

public class BaseTest {

    public WebDriver driver = null;
    public String url = null;
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setUpBrowser(String BaseURL) throws MalformedURLException {
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        url = BaseURL;
        navigateToPage();
    }
    // This setUpBrowser() method is marked with the @BeforeMethod annotation from TestNG and executes before each test method.
    // It sets up the browser, configures it, and opens the specified baseURL. It also prints information about the browser setup to the console.

    public  void navigateToPage() {
        getDriver().get(url);
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }
    // This getDriver() method returns the current instance of WebDriver associated with the current thread.

    @AfterMethod
    public void tearDown() {
        threadDriver.get().close();
        threadDriver.remove();
    }
    // The tearDown() method is executed after each test method (@AfterMethod),
    // and its purpose is to close the WebDriver and remove its instance from ThreadLocal.

    public WebDriver lambdaTest() throws MalformedURLException {

     //  Configured for the Test Pro lambdatest account

        String hubURL = "https://hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Firefox");
        capabilities.setCapability("browserVersion", "107.0");
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("user", "lambdatest.testpro");
        ltOptions.put("accessKey", "Op3WvHgSXBtuyR1TVO1wnBgA6qG34RvRcL9HWa8HLKzX4kSf5B");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", this.getClass().getName());
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.0.0");
        capabilities.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), capabilities);
    }
    // This lambdaTest() method returns an instance of WebDriver for remote testing using the LambdaTest service.

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://10.2.127.17:4444";

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
        }
    }

    // This pickBrowser() method selects and returns an instance of WebDriver depending on the passed browser parameter.
}
