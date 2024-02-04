import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Homework16 extends BaseTest {
    @Test
    public void registrationNavigation() {

        //prediction
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Steps
        String url = "https://testpro.io/";

        String registrationUrl = "https://qa.koel.app/registration";
        WebElement registrationLink = driver.findElement(By.cssSelector(("a[href='registration']"));
        registrationLink.click();


        driver.quit();
        Assert.assertEquals(driver.getCurrentUrl(),registrationUrl);

    }
}

//Slow down the test:
Thread.sleep(2000);
