import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {


        String url = "https://testpro.io/";
        getThreadLocal().get(url);
        Assert.assertEquals(getThreadLocal().getCurrentUrl(), url);
    }
}
