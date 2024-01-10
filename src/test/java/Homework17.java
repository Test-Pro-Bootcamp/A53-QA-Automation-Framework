import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedSongAddedMessage = "Added 1 song into \"Test Pro Playlist.\"";


        provideEmail("azahn007@gmail.com");
        providePassword("Koelpass");
        clickSubmit();
        Thread.sleep(2000);
        searchSong("Pluto");
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlaylist();
        Assert.assertEquals(getAddToPlaylistSuccessMsg(),expectedSongAddedMessage);

    }
    public void searchSong(String name)  throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.sendKeys(name);
        Thread.sleep(2000);
    }
    public void clickViewAllBtn() throws InterruptedException {
        WebElement viewAll = driver.findElement(By.cssSelector(" [data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(2000);

    }
    public void selectFirstSongResult() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
        Thread.sleep(2000);
    }
    public void clickAddToBtn() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToButton.click();
        Thread.sleep(2000);
    }
    public void choosePlaylist()  throws InterruptedException {
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test Pro Playlist')]"));
        playlist.click();
        Thread.sleep(2000);
    }

    public String getAddToPlaylistSuccessMsg() {
       WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
}








    }


















