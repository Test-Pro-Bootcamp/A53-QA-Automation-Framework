import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException{
        String expectedSongAddedMessage = "Added 1 Song into \"Test Pro Playlist.\"";
      navigateToPage();
      provideEmail("constantin@moraresco.com");
      providePassword("Nastika20$");
      clickSubmit();
      Thread.sleep(2000);
      searchSong(   "BornKing");
      clickViewAllbtn();
      selectFirstSongResult();
      clickAddToBtn();
      choosePlayList();
        Assert.assertEquals(getAddToPlaylistSuccessMsg(),expectedSongAddedMessage);

    }


    public String getAddToPlaylistSuccessMsg(){
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();


    }

    public void choosePlayList() throws InterruptedException {
        WebElement playlist = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]//li[contains(text(), 'Test Pro Playlist')]"));
        playlist.click();
        Thread.sleep(2000);


    }

    public void clickAddToBtn() throws InterruptedException{
        WebElement addToButton = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/span/button[2]"));
        addToButton.click();
        Thread.sleep(2000);


    }

    public void selectFirstSongResult() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
        Thread.sleep(2000);

    }

    public void clickViewAllbtn()throws InterruptedException {

        WebElement viewAll=driver.findElement(By.xpath( "//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(3000);
    }
    public void searchSong(String songName) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
    searchField.sendKeys(songName);
    Thread.sleep(2000);
    }


}

