//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//public class ActionsTests extends BaseTest {
//
//    //  Tests using WebElements and Action class
//
////  Test #1 - Context Click
//    @Test
//    public void playSong() throws InterruptedException {
//        provideEmail("demo@class.com");
//        providePassword("te$t$tudent");
//        clickSubmit();
//        chooseAllSongsList();
//        contextClickFirstSong();
//        choosePlayOption();
//        Assert.assertTrue(isSongPlaying());
//    }
//
//    //  Test #2 - WebElements
//    @Test
//    public void countSongsInPlaylist() {
//        //Prerequisite - user created playlist named "Playlist Demo" with at least 1 song
//
//        provideEmail("demo@class.com");
//        providePassword("te$t$tudent");
//        clickSubmit();
//        choosePlaylistByName("Playlist Demo");
//        displayAllSongs();
//        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
//        //verifies if the playlist details song count is equal to the retrieved number of songs
//    }
//
//    // Test #3 - Mouse Hover
//    @Test
//    public void hoverOverPlayButton()   {
//        provideEmail("demo@class.com");
//        providePassword("te$t$tudent");
//        clickSubmit();
//        Assert.assertTrue(hoverPlay().isDisplayed());
//    }
//    public WebElement hoverPlay()   {
//        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
//        actions.moveToElement(play).perform();
//        return wait.until(ExpectedConditions.visibilityOf(play));
//    }
//
//    public void chooseAllSongsList() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
//    }
//    public void contextClickFirstSong() throws InterruptedException {
//        WebElement firstSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
//        actions.contextClick(firstSongElement).perform();
//        Thread.sleep(2000);//added thread sleeps to show the right click during class (feel free to remove this)
//    }
//    public void choosePlayOption() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();
//    }
//    public boolean isSongPlaying() {
//        WebElement soundBarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid = 'sound-bar-play']")));
//        return soundBarVisualizer.isDisplayed();
//    }
//    public void choosePlaylistByName(String playlistName) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + playlistName + "')]"))).click();
//    }
//    public int countSongs() {//counts songs inside playlist
//        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
//    }
//    public String getPlaylistDetails() { //retrieves playlist details from playlist header (displays number of songs in playlist)
//        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
//    }
//    public void displayAllSongs() { //prints all songs inside the playlist - for demo purposes
//        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
//        System.out.println("Number of songs found: " + countSongs());
//        for (WebElement e : songList) {
//            System.out.println(e.getText());
//        }
//    }
//}
