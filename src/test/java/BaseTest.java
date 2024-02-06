import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public WebDriver driver;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
}