import Pages.AllSongsPage;
import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AllSongsTest extends BaseTest {


    String newPlaylistName = "Sample Edited Playlist";
    @Test
    public void playSongByContextClick() throws InterruptedException{

        navigateToUrl(url);
        provideEmail("andrew.simmons@testpro.io");
        providePassword("Andrew.Simmons24");
        clickSubmit();

        chooseAllSongsList();
        contextClickFirstSong();
        choosePlayOption();

        Assert.assertTrue(isSongPlaying());

    }

    /**
     * Exact same Test as PlaySongByContextClick.
     * This is an example of POM Implementation.
     * @throws InterruptedException
     */
    @Test
    public void playSongByRightClick () throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        BasePage basePage = new BasePage(driver);
        //Login
        loginPage.login();
        //homePage.allSongsList();
        homePage.goToAllSongsList();
        allSongsPage.contextClickFirstSong();
        allSongsPage.choosePlayOption();
        //Assertions
        Assert.assertTrue(basePage.isSongPlaying());
    }


    @Test
    public void hoverOverPlayBtn()  throws InterruptedException{
        navigateToUrl(url);
        provideEmail("andrew.simmons@testpro.io");
        providePassword("Andrew.Simmons24");
        clickSubmit();

        Thread.sleep(2000);

        Assert.assertTrue(hoverPlay().isDisplayed());

    }

    @Test
    public void countSongsInPlaylist() throws InterruptedException{
        loginToKoelApp();
        choosePlaylistByName("Playlist to count songs");
        displayAllSongs();
        Thread.sleep(2000);
        //Assertions
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
    }

    @Test
    public void renamePlaylist() throws InterruptedException{
        String updatePlaylistMsg = "Updated playlist \"Sample Edited Playlist.\"";

        loginToKoelApp();
        Thread.sleep(2000);
        doubleClickPlaylist();
        Thread.sleep(2000);
        enterNewPlaylistName();
        Thread.sleep(2000);
        //Assertions
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatePlaylistMsg);
    }



    //For Students to try
    // Create a test to hover over
    // play button and click on play and verify that the song is being played.




    //Tests End here

    public void chooseAllSongsList() throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }

    public void contextClickFirstSong() throws InterruptedException{
        WebElement firstSongInTheList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongInTheList).perform();
    }

    public void choosePlayOption() throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(("li.playback")))).click();
    }

    public boolean isSongPlaying() throws InterruptedException{
        WebElement soundBarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        return soundBarVisualizer.isDisplayed();
    }

    public WebElement hoverPlay(){
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(playBtn).perform();
        return wait.until(ExpectedConditions.visibilityOf(playBtn));
    }

    public void choosePlaylistByName (String playlistName){
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

    public void displayAllSongs() throws InterruptedException{
        Thread.sleep(2000);
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Songs found: "+countSongs());
        for (WebElement e : songList){
            System.out.println(e.getText());
        }
    }

    public void doubleClickPlaylist(){
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }

    public void enterNewPlaylistName(){
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        //Clear does not work since element has an attribute of required.
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg() {
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();
    }

}
