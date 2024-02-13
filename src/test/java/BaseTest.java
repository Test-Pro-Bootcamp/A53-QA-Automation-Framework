import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import javax.swing.text.html.Option;
import java.time.Duration;

public class BaseTest {

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser() {
        ChromeOptions Options = new ChromeOptions();
        Options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(Options);
        driver.manage().timeouts().implicityWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        navigateToUrl();
    }
}