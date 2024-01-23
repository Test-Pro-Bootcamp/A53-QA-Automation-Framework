import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.util.UUID;

public class BaseTest {
    @DataProvider(name="InvalidLoginData")

    public Object [][] getDataFromDataProviders(){
    return new Object[][]{
            {"invalid@mail.com", "invalidPassword"},
            {"azahn007@gmail.com", ""},
            {"","Koelpass"},
            {"",""}
    };

    }
    public WebDriver driver;
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public WebDriverWait wait ;


    public String url = "https://qa.koel.app/";
    public Actions actions= null;

    @BeforeSuite
      void setupClass() {
       WebDriverManager.chromedriver().setup();
       // WebDriverManager.firefoxdriver().setup();
    }
    @Parameters({"BaseUrl"})
    @BeforeMethod
    public void launchBrowser(String BaseUrl) throws MalformedURLException {
       /* ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver = new FirefoxDriver();*/
       // driver = pickBrowser(System.getProperty("browser"));
       threadDriver.set( pickBrowser(System.getProperty("browser")));


        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait= new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        actions = new Actions(getDriver());
       // driver.manage().window().maximize();
       // String url = BaseUrl;
        navigateToPage(BaseUrl);

    }

    public static WebDriver getDriver(){
        return threadDriver.get();
    }

    public void tearDown() {
        threadDriver.get().close();
        threadDriver.remove();
    }


      //  @AfterMethod
     // public void closeBrowser() {
     //   driver.quit();
     // }

    public void navigateToPage(String givenUrl) {
        getDriver().get(givenUrl);
    }

    public void provideEmail(String email) {
       // WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);

    }

    public void providePassword(String password) {
       // WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passwordField =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        //WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submit.click();
    }
    public void clickSaveButton() {
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

    public void provideProfileName(String randomName) {
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    public void provideCurrentPassword(String password) {
       // WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password'"));
        WebElement currentPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='current_password'")));
        currentPassword.clear();
        currentPassword.sendKeys(password);

    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", " ");
    }

    public void clickAvatarIcon() {
       // WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        avatarIcon.click();
    }

    public void loginToKoelApp(){
        provideEmail("azahn007@gmail.com");
        providePassword("Koelpass");
        clickSubmit();
    }

    public WebDriver pickBrowser(String browser)  throws MalformedURLException {
        String gridURL = "http://10.0.0.206:4444/";
        DesiredCapabilities caps = new DesiredCapabilities();
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();

            case "MircosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver();

            case "grid-edge": // gradle clean test -Dbrowser=grid-edge
            caps.setCapability("browserName","MicrosoftEdge");
            return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

            case "grid-firefox": // gradle clean test -Dbrowser=grid-firefox
                caps.setCapability("browserName","firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);

            case "grid-chrome": // gradle clean test -Dbrowser=grid-chrome
                caps.setCapability("browserName","chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);


            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
        }
    }

}
