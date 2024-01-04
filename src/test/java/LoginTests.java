import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void navigateToKoelApp() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
<<<<<<< Updated upstream
    public void loginValidEmailPassword() {
        //PreCondition
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //Manage Browser - wait for 10 seconds before failing/quitting.
=======
        public void loginValidEmailPassword() {

        //PreCondition
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); // if you wont allow all your browser will not open

        //Manage Browser - Wait for 10 sec before failing/quitting.
>>>>>>> Stashed changes
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Steps
        String url = "https://qa.koel.app/";
        driver.get(url);

        //Email Field
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
<<<<<<< Updated upstream
        emailField.sendKeys("demo@class.com");
        //Password Field
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
        //Submit button
=======
        emailField.sendKeys("utku.aktas94@testpro.io");

        //Password Field
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("ekga9uf6");

        //Submit Button
>>>>>>> Stashed changes
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        //Assertion
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
<<<<<<< Updated upstream
=======
//        Assert.assertTrue(avatarIcon.isDisplayed());
>>>>>>> Stashed changes
        Assert.assertTrue(avatarIcon.isDisplayed());

        //Quit
        driver.quit();
<<<<<<< Updated upstream
    }

    @Test
    public void loginWithInvalidEmailValidPassword() throws InterruptedException {
        //PreCondition
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //Manage Browser - wait for 10 seconds before failing/quitting.
=======
        }

    //Invalid Scenerio
    @Test
    public void loginWithInvalidEmailValidPassword() throws  InterruptedException{
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); // if you wont allow all your browser will not open

        //Manage Browser - Wait for 10 sec before failing/quitting.
>>>>>>> Stashed changes
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Steps
        String url = "https://qa.koel.app/";
        driver.get(url);

        //Email Field
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
<<<<<<< Updated upstream
        emailField.sendKeys("invalid@class.com");
        //Password Field
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
        //Submit button
=======
        emailField.sendKeys("invalid@testpro.io");

        //Password Field
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("ekga9uf6");

        //Submit Button
>>>>>>> Stashed changes
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        Thread.sleep(2000);
        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url);

<<<<<<< Updated upstream
        //close Browser
        driver.quit();
    }

    @Test
    public void loginWithInvalidPasswordAndValidEmail() throws InterruptedException {
        //PreCondition
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //Manage Browser - wait for 10 seconds before failing/quitting.
=======
        //Close Browser
        driver.quit();
    }

    //Invalid Scenerio
    @Test
    public void loginWithValidEmailInvalidPassword() throws  InterruptedException{
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); // if you wont allow all your browser will not open

        //Manage Browser - Wait for 10 sec before failing/quitting.
>>>>>>> Stashed changes
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Steps
        String url = "https://qa.koel.app/";
        driver.get(url);

        //Email Field
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
<<<<<<< Updated upstream
        emailField.sendKeys("demo@class.com");
        //Password Field
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("invalidPassword");
        //Submit button
=======
        emailField.sendKeys("utku.aktas94@testpro.io");

        //Password Field
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("1234568");

        //Submit Button
>>>>>>> Stashed changes
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        Thread.sleep(2000);
        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url);

<<<<<<< Updated upstream
        //close Browser
        driver.quit();
    }


}
=======
        //Close Browser
        driver.quit();
    }
}


















>>>>>>> Stashed changes
