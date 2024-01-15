import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import java.time.Duration;

public class Homework16 extends BaseTest{
    @Test

    public void registrationNavigation() {

        // Added ChromeOptions argument below to fix websocket error

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";

        driver.get(url);
        WebElement regLink = driver.findElement(By.xpath("//a[@href='registration']"));
        regLink.click();

        String newUrl = driver.getCurrentUrl();

        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), newUrl);

        driver.quit();


    }

}
