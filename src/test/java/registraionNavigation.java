import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class Homework16 extends BaseTest{
    @Test
    public void registrationNavigation() {

    // Added ChromeOptions argument below to fix websocket error
    org.openqa.selenium.chrome.ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

    WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement registrationLink = driver.findElement((By.cssSelector("[href='registration']"));
        registrationLink.click();
        String registrationURL = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(), registrationURL);

        driver.quit();
}
}
}
