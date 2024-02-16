import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.crypto.KeyAgreementSpi;
import java.util.List;


public class PlaySong extends BaseTest {
    String newPlaylistName = "Homework21 Playlist";

    @Test
    public void playSongByContextClick() throws InterruptedException {
        navigateToPage();
        provideEmail("constantin@moraresco.com");
        providePassword("Nastika20$");
        clickSubmit();
        chooseAllSongsList();
        contextClickFirstSong();
        choosePlayOption();
        Assert.assertTrue(isSongPlaying());
    }
@Test
public void countSongsInPlaylist() throws InterruptedException {
    navigateToPage();
    provideEmail("constantin@moraresco.com");
    providePassword("Nastika20$");
    clickSubmit();
    choosePlaylistByName("Playlist Demo");
    displayAllSongs();
    Thread.sleep(2000);
    Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));

}
@Test
public void renamePlaylist() throws InterruptedException{
        String updatePlaylistMsg = "Updated playlist \"Homework21 Playlist.\"";
    navigateToPage();
    provideEmail("constantin@moraresco.com");
    providePassword("Nastika20$");
    clickSubmit();
    Thread.sleep(2000);
    doubleClickPlaylist();
    Thread.sleep(2000);
    enterNewPlaylistName();
    //Assertions
    Assert.assertEquals(getRenamePlaylistSuccessMsg(),updatePlaylistMsg);
        
}

    public void doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }
public void enterNewPlaylistName(){
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
}
public String getRenamePlaylistSuccessMsg(){
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();
}
    public void choosePlaylistByName(String playlistName) {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+playlistName+"')]"))).click();

    }
public int countSongs(){
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();

}
public String getPlaylistDetails(){
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();

}
public void displayAllSongs(){
    List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
    System.out.println("Number of songs found: "+countSongs());
    for (WebElement e : songList){
        System.out.println(e.getText());
    }
}
    public void choosePlayOption() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@data-testid='song-context-menu']//ul//li[@class='playback']/span[1]"))).click();
    }

    public void contextClickFirstSong() throws InterruptedException {
        WebElement firstSongInTheList = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongInTheList).perform();
    }

    public void chooseAllSongsList() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }

    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        return soundBarVisualizer.isDisplayed();

    }

}