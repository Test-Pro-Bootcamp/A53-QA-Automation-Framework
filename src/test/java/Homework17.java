import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    @Test

    public void addSongToPlaylist() throws InterruptedException {
        //navigate to koel

        navigateToPage();
        //login with credentials
        provideEmail("daria.huzhvii@testpro.io");
        providePassword("VutYN7Kv");
        clickSubmit();
        //search dark days in search field
        songSearch();
        //click view all button
        viewAll();
        //click on the first song in playlist
        firstSongInList();
        addToList();
        //click add to gym playlist
        gymPlaylist();
        Thread.sleep(4000);
        //verify a notification message
        Assert.assertTrue(popUpMessage.isDisplayed());


    }

    public void songSearch() {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys("Dark Days");
    }

    public void viewAll() {
        WebElement viewAllButton = driver.findElement(By.cssSelector("h1>button"));
        viewAllButton.click();
    }

    public void firstSongInList() {
        WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr.song-item.selected"));
        firstSong.click();
    }
    public void addToList() {
        WebElement addButton = driver.findElement(By.cssSelector("[class='btn-add-to']"));
        addButton.click();
    }
    public void gymPlaylist () {
        WebElement addToGymPlaylist = driver.findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li.playlist"));
    }

        WebElement popUpMessage = driver.findElement(By.cssSelector("[class='success show']"));



}
