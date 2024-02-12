package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework16 {

    @Test
    public static void registrationNavigation() {
        WebDriverManager.chromedriver().setup();
        WebDriver Driver = new ChromeDriver();
        Driver.manage().window().maximize();
        Driver.get("https://qa.koel.app/");
        WebElement registration = Driver.findElement(By.xpath("//a[text()='Registration / Forgot password']"));
        registration.click();
        WebElement registrationPage = Driver.findElement(By.xpath("//h2[contains(text(),'Register new account or')]"));
        boolean status = registrationPage.isDisplayed();
        Assert.assertTrue(status);
        System.out.println("User is in the registration page");
    }
}
