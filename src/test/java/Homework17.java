import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{
    @Test
    public void addSongToPlaylist() throws InterruptedException{
        Thread.sleep(2000);
        provideEmail("demo@class.com");
        Thread.sleep(2000);
        providePassword("te$t$tudent");
        Thread.sleep(2000);
        clickSubmit();

        searchSong("HoliznaCC0");
        Thread.sleep(2000);
        viewAllBtnClick();
        Thread.sleep(2000);
        firstSongClick();
        Thread.sleep(2000);
        addToBtnClick();
        Thread.sleep(2000);
        choosePlaylist();
        Thread.sleep(2000);
        //Assertion
        verifyAddSongToPlaylistMessage("Test Pro Playlist");

    }

    //Help Methods
    //login
    //email password clickSubmit
    //Search for a song


    public void searchSong(String songName){

        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys(songName);
    }
    //Click 'View All' button
    public void viewAllBtnClick() {
        WebElement viewAllButton = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllButton.click();
    }
    //Click the first song in the search results
    public void firstSongClick() {
        WebElement firstSongInTheList = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSongInTheList.click();
    }
    /*public void clickOnAllSongs(){
        WebElement allSongsLink = driver.findElement(By.cssSelector(".menu li:nth-child(3)"));
        allSongsLink.click();
        //driver.get("https://https://qa.koel.app/#!/songs");
    }*/
    //Click 'ADD TO...' button
    public void addToBtnClick(){
        WebElement addToButton = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addToButton.click();
    }
    //Create new playlist with a unique name
    //Choose the playlist
    public void choosePlaylist(){
        WebElement playlist = driver.findElement(By.xpath("//*[@id='songResultsWrapper']//*[contains(text(), 'Test Pro Playlist' )]"));
        playlist.click();
    }
    ////*[@id='songResultsWrapper']//*[contains(text(), 'Test Pro Playlist' )]

    //Verify that a notification message appears and contains the text, "Added 1 song into {your playlist}".
    public void verifyAddSongToPlaylistMessage(String playlistName) throws InterruptedException{
        WebElement notification = driver.findElement(By.cssSelector("div.success"));
        //return notification.getText();
        String expectSongAddedMessage = "Added 1 song into \"" +playlistName+".\"";
        Assert.assertEquals(notification.getText(), expectSongAddedMessage);
    }
}

//div#searchForm input[type='search']
//input[type='search']
//button[@data-test='view-all-songs-btn']
//section[@id='songResultsWrapper']//tr[@class='song-item'][1]
//section[@id='songsWrapper']//tr[@class='song-item'][1]
//section#songsWrapper table.items tr:first-child
