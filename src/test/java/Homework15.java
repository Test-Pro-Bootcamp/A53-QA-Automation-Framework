import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework15 extends BaseTest {

    @Test
    public void openBrowser() {
        // Instantiate ChromeOptions and WebDriver
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the specified URL
        String url = "https://koel.app/";
        driver.get(url);

        // Assert that the current URL is as expected
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Close the browser
        driver.quit();
    }
}

