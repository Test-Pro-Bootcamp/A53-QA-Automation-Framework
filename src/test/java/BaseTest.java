import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
//Test
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
}
//Hello Test Commitments