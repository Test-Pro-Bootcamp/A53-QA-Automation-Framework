import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework16 extends BaseTest {
    @Test
    public void registrationNavigation() {

        org.openqa.selenium.chrome.ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement registrationLink = driver.findElement(By.cssSelector("[href = 'registration']"));
        registrationLink.click();
        String registrationUrl = "https://qa.koel.app/registraion";
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);

        driver.quit();
    }
}
