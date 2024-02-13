import io.github.bonigarcia.wdm.WebDriverManager; // Importing WebDriverManager library for managing WebDriver binaries
import org.openqa.selenium.By; // Importing By class for locating elements
import org.openqa.selenium.WebDriver; // Importing WebDriver interface for controlling the browser
import org.openqa.selenium.WebElement; // Importing WebElement interface for representing HTML elements
import org.openqa.selenium.chrome.ChromeDriver; // Importing ChromeDriver class for WebDriver implementation for Chrome browser
import org.openqa.selenium.chrome.ChromeOptions; // Importing ChromeOptions class for configuring ChromeDriver options
import org.openqa.selenium.support.ui.WebDriverWait; // Importing WebDriverWait class for explicit waits
import org.testng.annotations.BeforeMethod; // Importing BeforeMethod annotation for actions to be performed before each test method
import org.testng.annotations.BeforeSuite; // Importing BeforeSuite annotation for actions to be performed before all tests in a suite
import org.testng.annotations.Parameters; // Importing Parameters annotation for defining parameters in TestNG

import java.time.Duration; // Importing Duration class from java.time package for specifying time durations

// Class declaration for BaseTest
public class BaseTest {
    // Declaration of WebDriver and WebDriverWait variables
    protected WebDriver driver = null; // Initializing WebDriver variable
    protected WebDriverWait wait = null; // Initializing WebDriverWait variable

    // Method annotated with @BeforeSuite, executed once before all tests in the suite
    @BeforeSuite
    static void setupClass() {
        // Setting up WebDriverManager to manage ChromeDriver binaries
        WebDriverManager.chromedriver().setup();
    }

    // Method annotated with @BeforeMethod, executed before each test method
    @BeforeMethod
    @Parameters("BaseUrl") // Declaring parameter "BaseUrl" for getting base URL from TestNG XML file
    public void setUpDriver(String url) {
        // Creating ChromeOptions instance to configure ChromeDriver options
        ChromeOptions options = new ChromeOptions();
        // Adding various options to ChromeOptions
        options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        // Initializing ChromeDriver with configured options
        driver = new ChromeDriver(options);
        // Setting implicit wait timeout for WebDriver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Opening the specified URL
        url = "https://qa.koel.app"; // Overriding URL with specified value
        driver.get(url); // Navigating WebDriver to the specified URL
        // Initializing WebDriverWait with WebDriver and specified timeout
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void login(String email, String password) {
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}