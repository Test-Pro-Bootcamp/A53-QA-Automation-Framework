import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    //Data Providers
    @DataProvider(name="InvalidLoginData")
    public Object[][] getDataFromDataProviders(){
        return new Object[][]{
                {"invalid@mail.com", "wrongPassword"},
                {"demo@class.com", ""},
                {"", "te$t$tudent"},
                {"",""}
        };
    }
    public WebDriver driver;

    public String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {WebDriverManager.chromedriver().setup();}


    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(String BaseUrl) {
        //Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //Manage Browser
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //String url = BaseUrl;
        //navigate to Ur

        navigateToUrl(BaseUrl);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }


    void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type = 'email']"));
        emailField.clear();
        emailField.sendKeys(email);


    }

    void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector ("input[type = 'password']"));
        passwordField.clear();
        passwordField.sendKeys(password);

    }

    void clickSubmit() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type = 'submit']"));
        submitButton.click();
    }

    //Helper Method
    public void navigateToUrl(String givenUrl){
        driver.get(givenUrl);

    }
}