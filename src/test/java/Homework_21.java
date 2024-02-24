import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework_21 extends BaseTest {
    public static String newPlaylistName = "Saty Test";
    public static String playlistName = "Playlist renamed";

    @Test
    public void renamePlaylist() throws Throwable {
        LoginTest user = new LoginTest();
        user.loginToKoelApp();
        try {
            //if playlist already exists the script in the try block will get executed
            playlistRename();
            verifyEditPlaylistNotification();
        } catch (Exception e) {
            //if playlist is not available then the catch block will create a playlist and then renames it
            createPlaylist();
            playlistRename();
            verifyEditPlaylistNotification();
        }
    }

    public void createPlaylist() throws Throwable {
        WebElement addButton = driver.findElement(By.xpath("//i[@title='Create a new playlist']"));
        clickElement(addButton);
        WebElement newPlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]//li[text()='New Playlist']"));
        clickElement(newPlaylist);
        WebElement savePlaylist = driver.findElement(By.xpath("//input[@placeholder='↵ to save']"));
        elementToBeClickable(savePlaylist);
        savePlaylist.sendKeys(newPlaylistName);
        savePlaylist.sendKeys(Keys.ENTER);
        WebElement notification = driver.findElement(By.xpath("//div[@class='success show']"));
        elementToBeClickable(notification);
        elementToDisappear("//div[@class='success show']");
    }

    public void playlistRename() throws Throwable {
        WebElement playList = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]"));
        doubleClick(playList);
        WebElement tests = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/input"));
        tests.sendKeys(getKeysChord() + "A" + Keys.DELETE);
        tests.sendKeys(playlistName);
        tests.sendKeys(Keys.ENTER);
    }
    public void verifyEditPlaylistNotification() throws Throwable {
        WebElement notification = driver.findElement(By.xpath("//div[@class='success show']"));
        elementToBeClickable(notification);
        String notificationText = notification.getText();
        Assert.assertEquals("Updated playlist \""+playlistName+".\"" , notificationText);
        System.out.println("Playlist renamed successfully");
    }

    private static Keys getKeysChord() {
        //This method makes the script generic to run in both mac and windows OS
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println("Operating System: "+ os);
        if (os.contains("win")) {
            return Keys.CONTROL;
        } else if (os.contains("mac")) {
            return Keys.COMMAND;
        } else {
            // Default to CONTROL for other operating systems
            return Keys.COMMAND;
        }
    }
}
