import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AllSongsTest extends BaseTest {
    String newPlaylistName = "Sample Edited Playlist";


    @Test

    public void playSongByContextClick() throws InterruptedException {
        provideEmail("ramya.gudur@testpro.io");
        providePassword("Ammananna@65");
        clickSubmit();
        chooseAllSongsList();
        contextClickFirstSong();
        choosePlayOptions();
        Assert.assertTrue(isSongPlaying());


    }

    public boolean isSongPlaying() throws InterruptedException {
        WebElement soundBarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        return soundBarVisualizer.isDisplayed();
    }


    public void chooseAllSongsList() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }

    public void contextClickFirstSong() throws InterruptedException {
        WebElement firstSongInTheList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr .song-item:nth-child(1)")));
        actions.contextClick(firstSongInTheList).perform();
    }

    public void choosePlayOptions() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();
    }




    public void hoverOverPlayBtn() throws InterruptedException {
        loginToKoelApp();
        Thread.sleep(2000);
        Assert.assertTrue(hoverPlay().isDisplayed());
    }

    public WebElement hoverPlay() {
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(playBtn).perform();
        return wait.until(ExpectedConditions.visibilityOf(playBtn));
    }


    public void choosePlaylistByName(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), '" + playlistName + "']"))).click();

    }

    public int countSongs() {
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }

    public String getPlaylistDetails() {
        return driver.findElement(By.cssSelector("span.meta.test-secondary span.meta")).getText();

    }

    public WebElement displayAllSongs() {
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Songs found: " + countSongs());
        for (WebElement e : songList) {
            System.out.println(e.getText());

        }

        return null;
    }
    public void countSongsInPlaylist() throws InterruptedException {
        loginToKoelApp();
        choosePlaylistByName("Playlist to count songs");
        displayAllSongs();
        Thread.sleep(2000);
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));

    }
    public void renamePlaylist(){
        String updatedPlaylistMsg = "Updated playlist \"Sample Edited Playlist.\"";
        loginToKoelApp();
        doubleClickPlaylist();
        
        enterNewPlaylistName();

        String updatePlaylistMsg = null;
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatePlaylistMsg);

    }

    public void enterNewPlaylistName() {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A, Keys.BACK-SPACE"));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);

    }

    public void doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();

    }
    public String getRenamePlaylistSuccessMsg(){
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();
    }
}
