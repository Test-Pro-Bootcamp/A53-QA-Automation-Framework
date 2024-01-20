import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;


public class BaseTest {


    //Data Providers
    @DataProvider(name = "InvalidLoginData")
    public Object[][] getDataFromDataProviders() {
        return new Object[][]{
                {"invalid@mail.com", "invalidPassword"},
                {"demo@class.com", ""},
                {"", "te$t$tudent"},
                {"", ""}
        };
    }


    public WebDriver driver = null;
    public WebDriverWait wait = null;


    public Wait<WebDriver> fluentWait = null;
    public Actions actions = null;

    public String url = "https://qa.koel.app";


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    @Parameters({"BaseUrl"})
    @BeforeMethod
    public void launchBrowser(String BaseUrl) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //Manage Browser - wait for 10 seconds before failing/quitting.
        driver = new ChromeDriver(options);

        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Explicit Wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Fluent Wait
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        actions = new Actions(driver);
        driver.manage().window().maximize();

        //url = BaseUrl;

        //Navigate to URL
        navigateToUrl(BaseUrl);


    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }


    void provideEmail(String email) {

        WebElement emailField = wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']"))));
        //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    void providePassword(String password) {

        //WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    void clickSubmit() {

        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        //WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }

    //Helper Method
    public void navigateToUrl(String givenUrl) {
        driver.get(givenUrl);
    }

    public void loginToKoelApp(){
        navigateToUrl(url);
        provideEmail("andrew.simmons@testpro.io");
        providePassword("Andrew.Simmons24");
        clickSubmit();
    }

}





