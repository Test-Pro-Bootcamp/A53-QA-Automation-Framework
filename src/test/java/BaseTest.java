import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();
    private WebDriver driver;

    public static WebDriver getThreadLocal() {
        return THREAD_LOCAL.get();
    }


    @BeforeMethod
   public void setupBrowser() throws MalformedURLException {
        THREAD_LOCAL.set(pickBrowser(System.getProperty("browser")));
        THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        THREAD_LOCAL.get().manage().window().maximize();
        THREAD_LOCAL.get().manage().deleteAllCookies();
    }

    public WebDriver lambdaTest() throws MalformedURLException{
        String hubURL = "https://hub.lambdatest.com/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName","chrome");
        capabilities.setCapability("browserVersion","120.0");
        /*ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("macOS Sonoma");
        browserOptions.setBrowserVersion("120.0");*/
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "william.changtestpro");
        ltOptions.put("accessKey", "JOmLbPg431HRZd7MMkM37wfS9iWDmh27qbUrlM0Da1hsirbKIs");
        ltOptions.put("geoLocation", "US");
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("resolution", "2560x1440");
        ltOptions.put("project", "Untitled");
        ltOptions.put("name", "Koel User Tests");
        ltOptions.put("selenium_version", "4.5.0");
        ltOptions.put("driver_version", "120.0");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        capabilities.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(URI.create(hubURL).toURL(),capabilities);
    }
    public WebDriver pickBrowser(String browser) throws MalformedURLException{
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.86.249:4444";//"http://192.168.86.247:4444";
        switch (browser){
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "grid-firefox":
                caps.setCapability("browserName","firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-chrome":
                caps.setCapability("browserName","chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                WebDriverManager.chromedriver().clearDriverCache().setup();
                WebDriverManager.chromedriver().clearResolutionCache().setup();
               return driver = new ChromeDriver(options);
        }

    }

    @AfterMethod
    static void tearDown(){
        THREAD_LOCAL.get().close();
        THREAD_LOCAL.remove();
    }
}