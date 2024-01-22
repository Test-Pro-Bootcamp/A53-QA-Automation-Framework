import Pages.AllSongsPage;
import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


//things to try
//Create a test to hover over
//play button and click on play and verify that the song is being played

public class AllSongTest extends BaseTest{

    String newPlaylistName = "Sample Edited Playlist";

    @Test
    public void playSongByContextClick() {
        provideEmail("demo@class.com");
        //Thread.sleep(2000);
        providePassword("te$t$tudent");
        //Thread.sleep(2000);
        clickSubmit();

        chooseAllSongsList();
        contextClickFirstSong();
        choosePlayOption();
        //Assertions
        Assert.assertTrue(isSongPlaying());
    }
    @Test
    public void hoverOverPlayBtn() throws InterruptedException{
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);   //Test would not pass without this sleep
        //Assertions
        Assert.assertTrue(hoverPlay().isDisplayed());
    }
    @Test
    public void countSongsInPlaylist() throws InterruptedException{
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        choosePlaylistByName("Playlist to count songs");
        displayAllSongs();
        Thread.sleep(2000);   //Test would not pass without this sleep
        //Assertions
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
    }

    @Test
    public void renamePlaylist() throws InterruptedException{
        String updatePlaylistMsg = "Updated playlist \"Sample Edited Playlist.\"";
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);

        doubleClickPlaylist();
        Thread.sleep(2000);
        enterNewPlaylistName();
        Thread.sleep(2000);
        //Assertions
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatePlaylistMsg);
    }

    @Test
    public void playSongsByRightClick() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        BasePage basePage = new BasePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.login();

        homePage.goToAllSongsList();
        Thread.sleep(2000);
        allSongsPage.contextClickFirstSong();
        Thread.sleep(2000);
        allSongsPage.choosePlayOption();
        Thread.sleep(2000);

        Assert.assertTrue(basePage.isSongPlaying());
    }


    public void chooseAllSongsList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }
    public void contextClickFirstSong(){
        WebElement firstSongInTheList = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongInTheList).perform();
    }
    public void choosePlayOption(){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//nav[@class='menu song-menu']//ul//li[@class='playback']//span[1]")))
                .click();

       //        li.playback
       //        //nav[@class='menu song-menu']//ul//li[@class="playback"]
       //        //nav[@class='menu song-menu']//ul//li[@class='playback']//span[1]
    }
    public boolean isSongPlaying(){
        WebElement soundBarVisualizer = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        return soundBarVisualizer.isDisplayed();
    }

    public WebElement hoverPlay(){
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(playBtn).perform();
        return wait.until(ExpectedConditions.visibilityOf(playBtn));
    }

    public void choosePlaylistByName(String playlistName){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+playlistName+"')]")))
                .click();
        ////a[contains(text(),'Playlist to count songs')]
    }
    public int countSongs(){
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }
    public String getPlaylistDetails(){
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }
    public void displayAllSongs() throws InterruptedException{
        Thread.sleep(2000);   //Test would not pass without this sleep
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Songs found: " +countSongs());
        for (WebElement e : songList){
            System.out.println(e.getText());
        }
    }

    public void doubleClickPlaylist(){
        WebElement playlistElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }
    public void enterNewPlaylistName(){
        WebElement playlistInputField =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        //clear does not work since element has an attribute of required.
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public String getRenamePlaylistSuccessMsg(){
        WebElement notification =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

}
