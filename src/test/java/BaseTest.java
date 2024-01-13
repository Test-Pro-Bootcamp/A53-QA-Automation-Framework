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

    public WebDriver driver;

    public String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {WebDriverManager.chromedriver().setup();}

    @BeforeMethod
    public void launchBrowser(){
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //Manage Browser
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    void  provideEmail(){
        //Email Field
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("menderes.koc@testpro.io");
     }

    void providePassword(){
         //Password Field
         WebElement passWordField = driver.findElement(By.cssSelector("input[type='password']"));
         passWordField.clear();
         passWordField.sendKeys("VGGd8tOG");
     }

    void clickSubmit() {
        //Submit button
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

>>>>>>> Stashed changes

        //Chrome Option
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //Manage Browser - wait for 10 seconds before failing/quitting.
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //Navigate tto url
        navigateToUrl();
    }

    @AfterMethod
    public void closedBrowser(){
        driver.quit();
    }

    void provideEmail(String email){

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);

    }

    void providePassword(String password){

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    void clickSubmit(){

        WebElement clickButton = driver.findElement(By.cssSelector("button[type='submit']"));
        clickButton.click();
    }

    //Helper Method
    public void navigateToUrl(){
        driver.get(url);
    }
}