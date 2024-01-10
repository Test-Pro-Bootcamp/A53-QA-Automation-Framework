import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homework17<webElement> extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String expectedSongAddedMessage = "Added 1 Song into \"Test Pro Playlist.\"";

        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(  2000);
        searchSong("dark days");
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlayList();
        //Assertion
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);



    }

    private void providePassword(String te$t$tudent) {

    }

    public void provideEmail(String mail) {

    }

    private byte[] getAddToPlaylistSuccessMsg() {

        return new byte[0];
    }

    public void choosePlayList() {
        WebDriver driver = null;
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        Class<?> aClass = notification.getClass();
    }

    public void clickAddToBtn() throws InterruptedException {
        WebDriver driver = null;
        WebElement addToButton = driver.findElement(By.xpath("//selection[@id='songResultsWrapper']//button[@date-test='add-to-btn]"));
         ((WebElement) addToButton).click();
         Thread.sleep(2000);
    }

    public void selectFirstSongResult() throws InterruptedException {

        WebDriver driver = null;
        WebElement firstSong =  driver.findElement(By.xpath("//selection[@id='songResultsWrapper']//tr[@class='song-item][1]"));
        firstSong.click();
        Thread.sleep(2000);



    }

    private void clickViewAllBtn() throws InterruptedException {
        WebDriver driver = null;
        String s = "//button[@data-test='view-all-songs-btn']";
        webElement viewAll;
                Thread.sleep(2000);
    }

    private WebElement s(WebElement viewAll) {

        return viewAll;
    }

    public void searchSong(String songName) throws InterruptedException {

        WebDriver driver = null;
        WebElement searchField =driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        ((WebElement) searchField).sendKeys(songName);

        Thread.sleep(2000);



    }





    private void navigateToPage() {
        navigateTourl("https://qa.koel.app/");

    }








    private void clickSubmit() {
    }








    }


