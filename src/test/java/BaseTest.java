import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import webdriver.webDriver;

public class BaseTest {



    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
}