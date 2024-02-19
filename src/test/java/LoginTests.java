import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
@Test
public class LoginTests {
    public void LoginToKoel() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("vlad.sadokha@testpro.io");

        WebElement emailPassword = driver.findElement(By.cssSelector("input[type='password']"));
        emailPassword.clear();
        emailPassword.sendKeys("democlass");

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());

        driver.quit();
    }
}





