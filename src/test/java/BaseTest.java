import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Parameters({"BaseUrl"})
    @BeforeSuite

    public void setUpDriver(String BaseUrl) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        String url = "https://qa.koel.app"; // Overriding URL with specified value
        driver.get(BaseUrl); // Navigating WebDriver to the specified URL
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterSuite
    public void closeBrowser() {
        driver.quit();
    }
}