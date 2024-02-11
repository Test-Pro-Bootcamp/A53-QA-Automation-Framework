import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;


public class Homework16 extends BaseTest {

    @Test
    public void registrationNavigation() {
        // Prediction
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver();
        driver.get("https://qa.koel.app/");

        WebElement loginEmailButton = driver.findElement(By.cssSelector("input[type='email']"));
        loginEmailButton.clear();
        loginEmailButton.sendKeys("vlad.sadokha@testpro.io");

        WebElement passwordButton = driver.findElement(By.cssSelector("input[type='password']"));
        passwordButton.clear();
        passwordButton.sendKeys("democlass");

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        // Explicit wait for the registration link
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement registrationLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='registration']")));

        // Steps
        registrationLink.click();

        String registrationUrl = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);

        driver.quit();
    }
}




