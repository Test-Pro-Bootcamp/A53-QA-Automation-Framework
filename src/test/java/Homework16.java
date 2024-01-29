import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {

    @Test
    public class registrationNavigation() {

        //Precondition: SET UP CHROME
        ChromeOptions options = new ChromeOptions();
        //Prevents web-socket issues: if you dont have "origins=*" your browser won't open up.
        options.addArguments("--remote-allow-origins=*");
        //open browser: Chrome
        WebDriver driver = new ChromeDriver(options);
        //wait 10 seconds before closing tab: Forget about it.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //Steps: 1. Navigate: register button.
        String url = "https://qa.koel.app/";
        driver.get(url);

        //redirect to registration website:
        WebElement registrationLink = driver.findElement(By.cssSelector("a[href='registration']"));
        //Click to submit the find element.
        registrationLink.click();

        //Type your username into the login:
        /*EmailField.sendkeys("demo@class.com");

        //Remove excess code:
        EmailField.clear();

        //Password Field:
        WebElement PasswordField = driver.findElement(By.cssSelector("input[type='password']"));
        PasswordField.clear();
        PasswordField.sendkeys("te$t$tudent");

        //Submit Button:
        WebElement SubmitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        SubmitButton.click();

        //Assertions: Is user logo displayed?
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));

        //Are some elements displayed?
        Assert.assertTrue(userAvatar.isDisplayed());*/

        //Close the browser.
        driver.quit();
    }

    @Test
    public static void main(String[] args) {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");


        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://app.koel.com");
            WebElement element = driver.findElement(By.id("someId"));
            element.click();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }

    }
}

//Slow down the test:
Thread.sleep(2000);
