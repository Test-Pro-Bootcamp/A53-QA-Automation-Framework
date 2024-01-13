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
import java.time.Instant;
import java.util.Map;

public class BaseTest {

    protected static WebDriver driver;
    protected String url = null;
    protected WebDriverWait wait = null;

    @BeforeMethod
    static void setupClass() {
          WebDriverManager.chromedriver().setup();
    }
      @Parameters({"browser"})
      public WebDriver pickBrowser(String browser, Map<String, String> variantCapabilities) throws MalformedURLException {
          DesiredCapabilities caps = new DesiredCapabilities();

          String gridURL = " http://192.168.0.41:4444";

          if (variantCapabilities != null) {
              caps.merge(new DesiredCapabilities(variantCapabilities));
          }

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
}