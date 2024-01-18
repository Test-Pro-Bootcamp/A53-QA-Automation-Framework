import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork17 extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedSongAddedMessage = "Added 1 song into \"Test Pro Playlist.\"";
        //login

        //navigateToUrl();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        //Thread.sleep(2000);

        searchSong("memoria");
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlaylist();

        //Assertion

        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);

    }
    public String getAddToPlaylistSuccessMsg() {
        WebElement notification = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("div.success.show")));

        //WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

    public void choosePlaylist() throws InterruptedException{
        WebElement playlist = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test Pro Playlist')]")));
        //WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test Pro Playlist')]"));
        playlist.click();
        //Thread.sleep(2000);
    }


    public void clickAddToBtn() throws InterruptedException {
        WebElement addToButton = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']")));
        //WebElement addToButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToButton.click();
        //Thread.sleep(2000);
    }

    public void selectFirstSongResult() throws InterruptedException {
        WebElement firstSong =  wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]")));
        //WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
        //Thread.sleep(2000);
    }

    public void clickViewAllBtn() throws InterruptedException {
        WebElement viewAll = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//button[@data-test='view-all-songs-btn']")));
        //WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
        //Thread.sleep(2000);
    }

    public void searchSong(String songName) throws InterruptedException {
        WebElement searchField = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("div#searchForm input[type='search']")));
        //WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(songName);
        //Thread.sleep(2000);
    }


}
