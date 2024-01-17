import Pages.HomePage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

//    //Page Object
//    LoginPage loginPage = new LoginPage(driver);
//    HomePage homePage = new HomePage(driver);

    public WebDriver driver = null;

    public WebDriverWait wait = null;

    public String url = "https://qa.koel.app/";

    public Actions actions = null;

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
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        actions = new Actions(driver);

        //Navigate to Url
        url = BaseUrl;
        navigatorUrl();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }


    void provideEmail(String email){
        //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }
    //"demo@class.com"

    void providePassword(String password){
        //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    //"te$t$tudent"

    void clickSubmit(){
        //WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitButton.click();
    }

    //Helper Method
    public void navigatorUrl(){
        driver.get(url);
    }

    /*
    *Test Script using Page Object Model.
    *Locators used in these test were located using By abstract class.
    */


    @Test
    public void loginWithCorrectCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
//        loginPage.provideEmail("demo@class.com");
//        loginPage.providePassword("te$t$tudent");
//        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }
    @Test
    public void loginWithIncorrectCredentials() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);


        loginPage.provideEmail("demo1@class.com");
        loginPage.providePassword("te$t$tudent1");
        loginPage.clickSubmit();

        //Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),url);
//        try {
//            Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
//        }catch(NoSuchElementException e){
//            System.out.println("Element not displayed as expected");
//        }
    }

}