// Homework19.java

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework19 {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver and other configurations
    }

    @Test
    @Parameters("baseUrl")
    public void deletePlaylist(String baseUrl) {
        // Navigate to the specified URL
        driver.get(baseUrl);

        // Log in with credentials (use helper method)
        login("yourUsername", "yourPassword");

        // Click the playlist you want to delete or create a new one
        WebElement playlistElement = getPlaylistElement("PlaylistName");
        playlistElement.click();

        // Locate and click the delete button
        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(text(), 'x PLAYLIST')]"));
        deleteButton.click();

        // Verify the confirmation notification text
        String confirmationText = driver.findElement(By.id("confirmationMessage")).getText();
        assert confirmationText.contains("Deleted playlist");

        // Add more assertions or verifications as needed

        // Call the helper method to delete the playlist

    }

    @AfterClass
    public void tearDown() {
        // Clean up resources, close the browser, etc.
    }

    // Define helper methods
    private void login(String username, String password) {
        // Implement login functionality
    }

    private WebElement getPlaylistElement(String playlistName) {
        // Implement logic to find and return the playlist element
    }
}
