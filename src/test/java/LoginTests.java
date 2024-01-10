import Web.webElement;
import io.netty.util.Attribute;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicReference;

public class LoginTests extends BaseTest {
    private Attribute<Object> drive;
    private webElement passwordField;
    private String registrationUrl;

    @Test
    public void navigateTokoelApp() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://Testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public void loginvalidEmailPassword() {

        //Preconditions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Steps
        String url = "https://qa.koel.app/";
        driver.get(url);

        //Email Field

        webElement emailField = (webElement) driver.findElement(By.cssSelector("input[type='Email']"));
        emailField.clear();
        emailField.sendKeys("demo@class.com");

        //Password
        webElement passWordField = (webElement) driver.findElement(By.cssSelector("input[type='passWord']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
        //Submit
        webElement submitButton = (webElement) driver.findElement(By.cssSelector("button[type='submit']"));
        ((WebElement) submitButton).click();
        //Assertions
        webElement avatarIcon = (webElement) driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(((WebElement) avatarIcon).isDisplayed());
        //Quit
        driver.quit();


    }
@Test
public void registrationNavigation() {

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");

    WebDriver driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    String url = "https://qa.koel.app/";
    driver.get(url);
    webElement registrationLink = (webElement) driver.findElement(By.cssSelector("[href='registration']"));
    registrationLink.click();

    String registrationUrl = "https://qa.koel.app/registration";

    Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);
    driver.quit();


    }

}