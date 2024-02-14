import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class Homework19 extends BaseTest {
    private WebDriver driver;
    public PlaylistActionClass(WebDriver driver) {
        this.driver = driver;
    }
    public void renamePlaylist() {
        // Find the element for renaming the playlist
        WebElement playlistName = driver.findElement(By.ByCssSelector("playlist-name"));

        // Create an Actions instance
        Actions actions = new Actions(driver);

        // Click on the playlist name to initiate the rename process
        actions.click(playlistName).perform();

        // Input the new playlist name and press Enter
        actions.sendKeys("New Playlist Name").keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
    }
    public void explicitWaits() {
        // Wait for the element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("playlist-rename")));
    }
    public void removeThreadSleep() {
        // Remove all implementations of Thread.sleep()
        // Example: Thread.sleep(2000);
    }
}
