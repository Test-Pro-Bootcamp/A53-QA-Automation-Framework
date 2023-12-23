import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16Test {

    @Test
    public void registrationNavigation(){
        // Set up EdgeOptions with remote-allow-origins argument
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Initialize WebDriver with EdgeDriver and set implicit wait
        WebDriver driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Define the base URL
        String baseUrl = "https://qa.koel.app/";
        driver.get(baseUrl);

        // CSS selector and WebDriverWait
        // Find the registration link and click on it
        WebElement registrationLink = driver.findElement(By.cssSelector("a[href*='registration']"));
        registrationLink.click();

        // Wait for the registration page to load before asserting the URL
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("registration"));

        // Assert the current URL is the expected registration URL
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "registration");

        // Close the WebDriver session
        driver.quit();
    }
}