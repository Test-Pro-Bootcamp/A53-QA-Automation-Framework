import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    public String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void lauchBrowser(String BaseUrl){
        //Chrome Options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //Manage Browser - wait for 10 seconds before failing/quitting
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //Navigate to Url
        url = BaseUrl;
        navigatorUrl();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }


    void provideEmail(String email){
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }
    //"demo@class.com"

    void providePassword(String password){
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    //"te$t$tudent"

    void clickSubmit(){
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }

    //Helper Method
    public void navigatorUrl(){
        driver.get(url);
    }
}