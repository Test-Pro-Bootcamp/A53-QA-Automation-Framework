// Homework19.java

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    @Parameters("baseUrl")
    public void deletePlaylist(String baseUrl) {

        login();
        navigateToPlaylist();
        deletePlaylist();
        Assert.assertEquals();
    }

    public void login() throws InterruptedException {
        WebElement emailButton = driver.findElement(By.cssSelector(""));
        emailButton.sendKeys("vlad.sadokha@testpro.io");
        emailButton.click();

        WebElement passwordButton = driver.findElement(By.cssSelector(""));
        passwordButton.sendKeys("democlass");
        passwordButton.click();

        WebElement submitButton = driver.findElement(By.cssSelector(""));
        submitButton.click();
        Thread.sleep(2000);
    }

    public void navigateToPlaylist() throws InterruptedException {
        WebElement goPlaylist = driver.findElement(By.ByCssSelector(""));
        goPlaylist.click();
    }


}
