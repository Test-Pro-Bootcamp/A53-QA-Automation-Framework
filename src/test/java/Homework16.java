import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;



public class Homework16 extends BaseTest {

    //locators
    String registrationLinkLocator = "//form [@data-testid='login-form']//div/a";
    String submitButtonLocator = "[type='submit']";
    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement registrationLink = driver.findElement(By.xpath(registrationLinkLocator));
        registrationLink.click();

        WebElement submitButton = driver.findElement(By.cssSelector(submitButtonLocator));
        Assert.assertTrue(submitButton.isDisplayed());

        driver.quit();
    }
}