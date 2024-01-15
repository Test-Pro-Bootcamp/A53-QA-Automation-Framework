import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
//Test
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        // Manage browser - wait for 10 seconds before failing/quitting
        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get(BaseURL);
    }


    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();}

    void provideEmail(String email){
//        WebElement emailField =  driver.findElement((By.cssSelector("input[type='email']")));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    void providePassword(String password){
//        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passwordField = wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']"))));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    void clickSubmit(){
//        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submitButton.click();
    }

    void isLoggedIn(){
//        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    void clickOnThePlaylistAndDelete(String playlistName){
        try{

//        WebElement playlist = driver.findElement(By.xpath("//div[@id='mainWrapper']//a[contains(text(), '"+playlistName+"')]"));
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='mainWrapper']//a[contains(text(), '"+playlistName+"')]")));
        playlist.click();

//        WebElement deleteButton = driver.findElement(By.cssSelector("button.btn-delete-playlist"));
        WebElement deleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn-delete-playlist")));
        deleteButton.click();

//        WebElement okButton = driver.findElement(By.cssSelector("button.ok"));
        WebElement okButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.ok")));
        okButton.click();

//        WebElement warningMessage = driver.findElement(By.cssSelector("div.success"));
        WebElement warningMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success")));
        Assert.assertTrue(warningMessage.isDisplayed());
        Assert.assertEquals("Deleted playlist \"" +playlistName+".\"",warningMessage.getText());
        }catch(Exception e){
            System.out.println("Something went wrong!! -> " + e);
        }
    }


}
//Hello Test Commitments