import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
public class BaseTest {

    public WebDriver driver = null;
    public String url = "https://qa.koel.app/";

    @BeforeSuite
    void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void launchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
      @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
    public void navigateToPage() {
        driver.get(url);
    }
    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }
}

