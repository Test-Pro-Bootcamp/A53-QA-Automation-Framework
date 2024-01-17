import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;


import java.time.Duration;
@Test
public class Homework17 extends BaseTest  {

    public void addSongToPlaylist() throws InterruptedException{

        driver.get(url);

        //Email Field
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("dmitry.lobachev@testpro.io");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("Chebureki5!");

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        Thread.sleep(2000);


        WebElement searchBar = driver.findElement(By.cssSelector("input[type='search']"));
        searchBar.clear();
        searchBar.sendKeys("Dark Days");

        clickViewAll();
        clickSong();
        addToPlaylist();

        Thread.sleep(500);

        WebElement successAlert = driver.findElement(By.cssSelector(".alertify-logs .success"));
        String correctAlert = "Added 1 song into \"AutoTest.\"";
        Assert.assertEquals(successAlert.getText(), correctAlert );

         /*WebElement addedPlaylist = driver.findElement(By.xpath("//*[@id='sidebar']//*[contains(text(), \"AutoTest\")]"));
        addedPlaylist.click();
        WebElement addedSong = driver.findElement(By.xpath)*/
        driver.quit();


    }

}
