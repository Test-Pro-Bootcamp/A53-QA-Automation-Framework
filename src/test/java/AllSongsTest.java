import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class AllSongsTest extends BaseTest{
    String newPlaylistName = "Sample Edited Playlist";

    public void playSongByContextClick () throws InterruptedException {
        provideEmail("azahn007@gmail.com");
        providePassword("Koelpass");
        clickSubmit();
        chooseAllSongsList();
        contextClickFirstSong();
        choosePlayOption();
        //Assertions
        Assert.assertTrue(isSongPlaying());
    }
    @Test
    public void hoverOverPlayBtn() throws InterruptedException{
        loginToKoelApp();
        Thread.sleep(2000);
        Assert.assertTrue(hoverPlay().isDisplayed());

    }
    @Test
    public void countSongsInPlaylist() throws InterruptedException{
        loginToKoelApp();
        choosePlaylistByName("Postman HW");
        displayAllSongs();
        Thread.sleep(2000);
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));

    }
    @Test
    public void renamePlaylist()throws InterruptedException {
        String updatePlaylistMsg = "Updated playlist \"Sample Edited Playlist.\"";

        loginToKoelApp();
        doubleClickPlaylist();
        //Thread.sleep(2000);
        enterNewPlaylistName();
        //Thread.sleep(2000);
        Assert.assertEquals(getRenamePlaylistSuccessMsg(),updatePlaylistMsg);


    }






    public void chooseAllSongsList() throws InterruptedException {
         wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();

    }
    public void contextClickFirstSong() throws InterruptedException {
        WebElement firstSongInList= wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongInList).perform();
    }
    public void choosePlayOption() throws InterruptedException {
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();

    }
    public boolean isSongPlaying() throws InterruptedException {
        WebElement soundBarVisualizer = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        return soundBarVisualizer.isDisplayed();
    }
        public WebElement hoverPlay(){
            WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn]"));
            actions.moveToElement(playBtn).perform();
            return wait.until(ExpectedConditions.visibilityOf(playBtn));
        }

        public void choosePlaylistByName(String playlistName){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+playlistName+"')]")))
                .click();

        }
        public int countSongs(){
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();

        }
        public String getPlaylistDetails(){
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
        }
        public void displayAllSongs() throws InterruptedException {
            Thread.sleep(2000);
            List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
            System.out.println("Number of Songs found: "+countSongs());
            for (WebElement e: songList){
                System.out.println(e.getText());

            }
        }
        public void doubleClickPlaylist(){
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();

        }
        public void enterNewPlaylistName(){
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg(){
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();
    }

}





