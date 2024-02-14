import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.time.Duration;


public class BaseTest {
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    protected WebDriver driver;
    protected WebDriverWait wait;

    wait = new WebDriver(driver, 10);
    driver = new ChromeDriver;
    @Parameters({"BaseURL"})
    @BeforeMethod
    public void launchBrowser(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        driver.manage().window().maximize();
    }
}

