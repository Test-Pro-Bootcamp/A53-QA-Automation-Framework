import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {

    @Test
    public void loginValidEmailPassword() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("vlad.sadokha@testpro.io");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("Mukmuk11");

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        driver.quit();

        //to go: Search song, view all, select song, click add to button, choose playlist, assertions (making sure it's correct).
    }

    @Test
    public void searchSong() throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys("Algorithms");
        Thread.sleep(2000);
    }

    @Test
    public void viewAllBtn() throws InterruptedException {
        WebElement viewAll = driver.findElement(By.cssSelector("//button[testid='home-view-all-recently-played-btn']"));
        viewAll.click();
        Thread.sleep(2000);
    }

    @Test
    public void selectedFirstSong() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//section[id='songResultsWraper']//tr[@class='song-item'][1]"));
        firstSong.click();
        Thread.sleep(2000);
    }

    @Test
    public void clickAdToBtn() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.xpath("//section[id='songResultsWraper']//tr[@class='song-item'][1]"));
        clickAdToBtn().click();
        Thread.sleep(2000);
    }
}

