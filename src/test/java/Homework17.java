import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;


public class Homework17 extends BaseTest {
        @Test
        public void addSongToPlaylist() throws InterruptedException {

            // Added ChromeOptions argument
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            // Manage Browser
            WebDriver driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            //Steps
            String url = "https://qa.koel.app";
            driver.get(url);

            //Email
            WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
            emailField.clear();
            emailField.sendKeys("valeriya.trygubova@testpro.io");

            //Password
            WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
            passwordField.clear();
            passwordField.sendKeys("ltZaqmXZ");

            //Submit
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
            loginButton.click();

            //Search
            WebElement searchField = driver.findElement(By.cssSelector("input[type=search]"));
            searchField.clear();
            searchField.sendKeys("For the Poor");

            //View All
            WebElement viewAll = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
            viewAll.click();

            //Select First Song
            WebElement firstSongInTheList = driver.findElement(By.cssSelector("section#songResultsWrapper table.items tr:first-child"));
            firstSongInTheList.click();

            //Add
            WebElement addToButton = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
            addToButton.click();

            //Select
            WebElement playlist = driver.findElement(By.xpath("//*[@id='songResultsWrapper']//*[contains(text(), 'Bops')]"));
            playlist.click();

            Thread.sleep(2000);

            //Assert
            WebElement warningMessage = driver.findElement(By.cssSelector("div.success.show"));
            Assert.assertTrue(warningMessage.isDisplayed());
            Assert.assertEquals("Added 1 song into 'Bops'", warningMessage.getText());
                    System.out.println("Warning message: " + warningMessage.getText());

            Thread.sleep(2000);

            driver.quit();

        }
    }

