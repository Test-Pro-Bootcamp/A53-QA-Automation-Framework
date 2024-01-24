import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.time.Duration;

public class Homework20Test {
    WebDriver driver;

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void loginUser(String BaseURL) {

        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(BaseURL);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("william.chang@testpro.io");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("te$tStudent");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }


    @Test
    public void deletePlaylist() throws InterruptedException {

        driver.findElement(By.xpath("//li[@class='playlist playlist'][1]")).click();
        driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']")).click();

        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3));
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='success show']")));
        WebElement successPopup = driver.findElement(By.xpath("//*[@class='success show']"));
        Assert.assertEquals(successPopup.getText(), "Deleted playlist \"NewPlaylist.\"");

    }
}