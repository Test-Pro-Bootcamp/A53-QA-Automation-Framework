import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework15 extends BaseTest {
    @Test
    public void openBrowser() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://testpro.io/";
        driver.get(url);
        //assertEquals makes sure that the url youre trying to get matches with the URL you put in.
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
}
