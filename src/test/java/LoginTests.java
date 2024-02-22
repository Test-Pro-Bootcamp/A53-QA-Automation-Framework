import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import java.time.Duration;

public class Homework15 extends BaseTest {
    public WebDriver driver;
    @Test
    public void loginToKoel() throws InterruptedException {
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            ChromeDriver driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String url = "https://qa.koel.app/";
            driver.get(url);
            WebElement emailOpen = driver.findElement(By.cssSelector("input[type='email']"));
            emailOpen.clear();
            emailOpen.sendKeys("vlad.sadokha@testpro.io");
            WebElement passwordOpen = driver.findElement(By.cssSelector("input[type='password']"));
            passwordOpen.clear();
            passwordOpen.sendKeys("democlass");
            WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
            submitButton.click();
            WebElement iconShow = driver.findElement(By.cssSelector("img[class='avatar']"));
            Assert.assertTrue(iconShow.isDisplayed());
            Thread.sleep(2000);
        } catch(Exception e) {
            System.out.println("Breh" +e);
        }
        driver.quit();
    }
}




