import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework17 extends BaseTest{

    String emailAddr = "vlad.kashchuk@testpro.io";
    String password = "Q4sNKxVN";
    @Test (enabled = false)
    void loginToPlayer() {
        driver.get("https://qa.koel.app/");
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(emailAddr);

        WebElement pwField = driver.findElement(By.cssSelector("input[type='password']"));
        pwField.clear();
        pwField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }

    @Test(enabled = false)
    void searchSong(String songName) {
        WebElement searchField = driver.findElement(By.cssSelector("input[type=search]"));
        searchField.clear();
        searchField.sendKeys(songName);
        WebElement viewAll = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAll.click();


    }

    @Test(enabled = false)
    void addSongToPlaylist(int listIndex,String playlist) throws InterruptedException {
        List<WebElement> searchResultList = driver.findElements(By.cssSelector("#songResultsWrapper .song-item"));
        WebElement soughtSong = searchResultList.get(listIndex);
        soughtSong.click();
        WebElement addSongButton = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        addSongButton.click();
        List<WebElement> availablePlaylists = driver.findElements(By.cssSelector("section[id='songResultsWrapper'] li"));
        for (WebElement soughtPlaylist:availablePlaylists) {
            if (soughtPlaylist.getText().contains(playlist)) {
                soughtPlaylist.click();
            }
        }
        WebElement confirmationBanner = driver.findElement(By.cssSelector("[class='success show']"));
        Assert.assertTrue(confirmationBanner.isDisplayed());
    }

    @Test
    void addSongToPlaylist() throws InterruptedException {
        loginToPlayer();
        searchSong("dee");
        addSongToPlaylist(0, "Custom");
    }
}

