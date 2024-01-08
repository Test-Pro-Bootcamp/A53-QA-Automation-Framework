import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork16 extends BaseTest {
    @Test
    public void registrationNavigation() {

        //Preconditions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Steps
        String url = "https://qa.koel.app/";
        driver.get(url);
        //EmailField
        WebElement emailField = driver.findElement(By.cssSelector ("input[type = 'email']"));
        emailField.clear();
        emailField.sendKeys("demo@class.com");
        //passwordField
        WebElement passwordField = driver.findElement(By.cssSelector ("input[type = 'password']"));
        passwordField.clear();
        passwordField.sendKeys("wrongPassword");
        //Submit button
        WebElement submitButton = driver.findElement(By.cssSelector ("button[type = 'submit']"));
        submitButton.click();
        //registrationField
        WebElement registrationLink = driver.findElement(By.cssSelector ("[href='registration']"));
        registrationLink.click();
         String registrationUrl = "https://qa.koel.app/registration";

        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);
        //quit
        driver.quit();

    }
}
