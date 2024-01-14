import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import static java.sql.DriverManager.getDriver;

public class BaseTest {

    protected static WebDriver driver;
    protected String url;
    protected WebDriverWait wait = null;
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadDriver.get();
    }
    private void navigateToPage() {
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setUpBrowser(String BaseURL) throws MalformedURLException {
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        url = BaseURL;
        navigateToPage();
    }
       @Parameters({"browser"})
    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        String gridURL = " http://192.168.0.41:4444";

        switch(browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();

            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);

            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
       }
    }

    public WebDriver lambdaTest() throws MalformedURLException {

        String hubURL = "https://hub.lambdatest.com/wd/hub";

        //Below was copied from Lambdatest
        //ChromeOptions browserOptions = new ChromeOptions();
        //browserOptions.setPlatformName("Windows 10");
        //browserOptions.setBrowserVersion("120.0");
        //HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        //ltOptions.put("username", "john.wolschlegertestpro");
        //ltOptions.put("accessKey", "tlXnGbezyhmB5skuvlNTb3eYu58yItec2vXFoZzcVqtltXvELq");
        //ltOptions.put("project", "Untitled");
        //ltOptions.put("selenium_version", "4.0.0");
        //ltOptions.put("w3c", true);
        //browserOptions.setCapability("LT:Options", ltOptions);

        //return new RemoteWebDriver(new URL(hubURL), browserOptions;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "119.0");
        HashMap<String, Object> ltOptions = new HashMap();
        ltOptions.put("user", "john.wolschlegertestpro");
        ltOptions.put("accessKey", "tlXnGbezyhmB5skuvlNTb3eYu58yItec2vXFoZzcVqtltXvELq");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", this.getClass().getName());
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium version", "4.0.0");
        capabilities.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), capabilities);
    }

    @AfterMethod
    public void tearDown() {
        threadDriver.get().close();
        threadDriver.remove();
  }
}