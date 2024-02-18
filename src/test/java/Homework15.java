import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework15 extends BaseTest {

    @Test
    public void LoginEmail() {
        //initiallize chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //OpenChrome driver (connect script to web) initialize ChromeOptions and WebDriver
        WebDriver driver = new ChromeOptions();
        //makes sure that it takes the time to search for element before failing test case Asap.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //String url
        String url = "https://qa.koel.app/";
        //command driver to get this url
        driver.get(url);
        //Confirm if it does this

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.sendKeys("HelloWorld");
        emailField.click();

        Assert.assertEquals(driver.getCurrentUrl(), url);
        //End
        driver.quit();
    }
}


