import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import org.openqa.selenium.*; // Imports Selenium WebDriver classes
import org.openqa.selenium.support.ui.ExpectedConditions; // Imports Selenium wait conditions
import org.testng.Assert; // Imports TestNG assertion library
import org.testng.annotations.Test; // Imports TestNG annotations

public class Homework20 extends BaseTest {

    // Prerequisite: At least one user-created playlist
    String newPlaylistName = "Sample Edited Playlist"; // Variable for the new playlist name

    @Test
    public void renamePlaylist() {

        String updatedPlaylistMsg = "Updated playlist \"Sample Edited Playlist.\""; // Expected success message

        provideEmail("demo@class.com"); // Method to provide an email
        providePassword("te$t$tudent"); // Method to provide a password
        clickSubmit(); // Method to click the submit button
        doubleClickPlaylist(); // Method to double-click a playlist
        enterNewPlaylistName(); // Method to enter the new playlist name
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlaylistMsg); // Assert that the success message matches the expected one
    }

    public void doubleClickPlaylist() {
        // Wait for the playlist element to be visible and double-click it
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }

    public void enterNewPlaylistName() {
        // Enter the new playlist name by selecting all, deleting, and typing
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists li:nth-child(3)")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE)); // Select all and delete
        playlistInputField.sendKeys(newPlaylistName); // Enter the new playlist name
        playlistInputField.sendKeys(Keys.ENTER); // Press Enter to save the changes
    }

    public String getRenamePlaylistSuccessMsg() {
        // Wait for the success notification to be visible and return its text
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
}
