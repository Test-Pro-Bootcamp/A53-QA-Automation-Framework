import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Homework17 {



    import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;

    public class Homework17 extends BaseTest {

        @Test
        public void addSongToPlaylist() {
            // Assuming you have a method to initialize the WebDriver in your BaseTest class
            WebDriver driver = initializeDriver();

            // Navigate to the Koel app
            driver.get("https://qa.koel.app/");

            // Login with your credentials
            WebElement usernameInput = driver.findElement(By.id("username")); // Adjust the locator based on your HTML
            WebElement passwordInput = driver.findElement(By.id("password")); // Adjust the locator based on your HTML
            WebElement loginButton = driver.findElement(By.id("loginButton")); // Adjust the locator based on your HTML

            // Enter your credentials and click the login button
            usernameInput.sendKeys("vlad.sadokha@testpro.io");
            passwordInput.sendKeys("Mukmuk11");
            loginButton.click();

            // Search for a song
            WebElement searchInput = driver.findElement(By.id("search")); // Adjust the locator based on your HTML
            WebElement viewAllButton = driver.findElement(By.id("viewAllButton")); // Adjust the locator based on your HTML

            searchInput.sendKeys("Epic Song");
            viewAllButton.click();

            // Click the first song in the search results
            WebElement firstSong = driver.findElement(By.xpath("//div[@class='search-results']/div[1]/div[@class='Epic Song']")); // Adjust the locator based on your HTML
            firstSong.click();

            // Click 'ADD TO...' button
            WebElement addToButton = driver.findElement(By.id("addToButton")); // Adjust the locator based on your HTML
            addToButton.click();

            // Choose the playlist (you may need to locate and click on the playlist dropdown and select or create a new playlist)

            // Wait for the notification to appear
            WebElement notification = driver.findElement(By.className("notification-message")); // Adjust the locator based on your HTML

            // Verify the notification message
            String actualMessage = notification.getText();
            String expectedMessage = "Added 1 song into {your playlist}"; // Adjust the expected playlist name
            assertEquals(expectedMessage, actualMessage);

            // Close the browser or perform other necessary cleanup
            driver.quit();
        }
    }
}
