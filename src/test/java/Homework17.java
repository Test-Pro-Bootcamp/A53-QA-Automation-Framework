import org.openqa.selenium.By; // Importing By class for locating elements
import org.openqa.selenium.WebElement; // Importing WebElement interface for representing HTML elements
import org.testng.Assert; // Importing Assert class for assertions
import org.testng.annotations.Test; // Importing Test annotation from TestNG

// Class declaration for Homework17, extending BaseTest class
public class Homework17 extends BaseTest {

    // Test method to add a song to the playlist
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        // Logging in with specified email and password
        login("vlad.sadokha@testpro.io", "democlass");

        // Performing steps to add a song to the playlist
        searchSong("Song"); // Searching for a song with keyword "Song"
        viewAllSearchResults(); // Viewing all search results
        selectFirstSongResult(); // Selecting the first song from the search results
        clickAddToButton(); // Clicking on the "Add to" button
        choosePlaylist(); // Choosing the playlist named "privet"

        // Asserting that the notification pop-up is present
        Assert.assertTrue(isNotificationPopUpPresent());
    }

    // Method to search for a song using a keyword
    public void searchSong(String songTitleKeyword) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(songTitleKeyword); // Typing the song title keyword into the search field
        Thread.sleep(2000); // Pausing execution for 2 seconds
    }

    // Method to view all search results
    public void viewAllSearchResults() throws InterruptedException {
        WebElement viewAllSearchResult = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAllSearchResult.click(); // Clicking on the button to view all search results
        Thread.sleep(2000); // Pausing execution for 2 seconds
    }

    // Method to select the first song from search results
    public void selectFirstSongResult() throws InterruptedException {
        WebElement viewAllFirstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        viewAllFirstSongResult.click(); // Clicking on the title of the first song in the search results
        Thread.sleep(2000); // Pausing execution for 2 seconds
    }

    // Method to click on the "Add to" button
    public void clickAddToButton() throws InterruptedException {
        WebElement addTo = driver.findElement(By.cssSelector("button.btn-add-to"));
        addTo.click(); // Clicking on the "Add to" button
        Thread.sleep(2000); // Pausing execution for 2 seconds
    }

    // Method to choose a playlist by name
    public void choosePlaylist() throws InterruptedException {
        WebElement playListNameElement = driver.findElement(By.xpath("//section[@id='songsResultsWrapper']//li[@class='favorites']"));
        playListNameElement.click(); // Clicking on the playlist with the specified name
        Thread.sleep(2000); // Pausing execution for 2 seconds
    }

    // Method to check if the notification pop-up is present
    public boolean isNotificationPopUpPresent() {
        WebElement notificationText = driver.findElement(By.cssSelector("div.success.show"));
        return notificationText.isDisplayed(); // Returning true if the notification pop-up is displayed
    }

}
