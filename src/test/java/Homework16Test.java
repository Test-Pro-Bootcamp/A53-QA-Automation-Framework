
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork16Test {

    @Test

    public void registrationNavigation() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/registration";
        driver.get(url);
        WebElement registrationNavigation = driver.findElement(By.cssSelector("a[href*='registration']"));
        registrationNavigation.click();

        WebElement registerAccount = driver.findElement(By.cssSelector("h2[style^='padding']"));
        Assert.assertTrue(registerAccount.isDisplayed());
        driver.quit();
    }
}
