import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class registraionNavigation extends BaseTest{
    @Test
    public void registrationNavigation

    // Added ChromeOptions argument below to fix websocket error
    org.openqa.selenium.chrome.ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

    WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    String url = "https://qa.koel.app/";
        driver.get(url);
        registration.click();
        Assert.assertEquals(driver.getCurrentUrl(https://qa.koel.app/registration), url);
        driver.quit();
}
}
}
