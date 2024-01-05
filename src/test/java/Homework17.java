import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class Homework17 extends BaseTest  {

    @Test
    public void addSongToPlaylist() throws InterruptedException{

        driver.get(url);
        //Login
        //Email Field
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("andrew.simmons@testpro.io");
        //Password Field
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("Andrew.Simmons24");
        //Submit button
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        Thread.sleep(2000);


        //Click on the search bar and search for a song
        WebElement searchBar = driver.findElement(By.cssSelector("input[type='search']"));
        searchBar.clear();
        searchBar.sendKeys("Dark Days");

        //Find and Click on the View All Button
        clickViewAll();

        //Click the first song on the page
        clickSong();

        //Add the song to a playlist
        addToPlaylist();

        Thread.sleep(500);

        //Verify
        WebElement successAlert = driver.findElement(By.cssSelector(".alertify-logs .success"));
        String correctAlert = "Added 1 song into \"AutoTest.\"";
        Assert.assertEquals(successAlert.getText(), correctAlert );

        //Delete song from playlist so it can be tested again.
        /*WebElement addedPlaylist = driver.findElement(By.xpath("//*[@id='sidebar']//*[contains(text(), \"AutoTest\")]"));
        addedPlaylist.click();

        WebElement addedSong = driver.findElement(By.xpath)*/
        driver.quit();
    }

    //Helper Methods

    public void clickViewAll(){
        WebElement viewAllButton = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllButton.click();
    }

    //Click on the first Song on the Page
    public void clickSong(){
        WebElement firstSong = driver.findElement(By.cssSelector(".search-results .items tr:nth-child(1)"));
        firstSong.click();
    }

    //Add Song to playlist
    public void addToPlaylist(){
        WebElement addToButton = driver.findElement(By.cssSelector("button.btn-add-to"));
        WebElement addToPlaylist = driver.findElement(By.cssSelector("#songResultsWrapper .existing-playlists  li:nth-child(5)"));
        addToButton.click();
        addToPlaylist.click();
    }

}
