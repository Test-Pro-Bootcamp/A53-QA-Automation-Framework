import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework_17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws Throwable {
        LoginTest user = new LoginTest();
        user.loginToKoelApp();
        verifyLogin();

        try {
            WebElement playList = driver.findElement(By.xpath("//li[@class='playlist playlist']"));
            addSong();
        } catch (Exception e) {
            WebElement addButton = driver.findElement(By.xpath("//i[@title='Create a new playlist']"));
            elementToBeClickable(addButton);
            addButton.click();
            WebElement newPlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]//li[text()='New Playlist']"));
            elementToBeClickable(newPlaylist);
            newPlaylist.click();
            WebElement savePlaylist = driver.findElement(By.xpath("//input[@placeholder='↵ to save']"));
            elementToBeClickable(savePlaylist);
            savePlaylist.sendKeys("SatyTest");
            savePlaylist.sendKeys(Keys.ENTER);
            WebElement notification = driver.findElement(By.xpath("//div[@class='success show']"));
            elementToBeClickable(notification);
            elementToDisappear("//div[@class='success show']");
            addSong();
        }
    }

    public void addSong() throws Throwable {
        searchSong();
        viewAllSearchList();
        selectFirstSongInTheResult();
        clickAddOnButton();
        choosePlaylist();
        verifyAddSongNotification();
    }

    public void verifyLogin() throws Throwable {
        WebElement yourMusic = driver.findElement(By.xpath("//span[@class='name']"));
        elementToBeClickable(yourMusic);
        boolean status = yourMusic.isEnabled();
        Assert.assertTrue(status);
    }

    public void searchSong() throws Throwable {
        WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
        elementToBeClickable(search);
        search.sendKeys("Song");
    }

    public void viewAllSearchList() throws Throwable {
        WebElement viewAll = driver.findElement(By.xpath("(//section[@class='songs']//button)[1]"));
        elementToBeClickable(viewAll);
        viewAll.click();
    }

    public void selectFirstSongInTheResult() throws Throwable {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//div//div//tr[1]"));
        elementToBeClickable(firstSong);
        firstSong.click();
    }

    public void clickAddOnButton() throws Throwable {
        WebElement addTo = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/span/button[2]"));
        elementToBeClickable(addTo);
        addTo.click();
    }

    public void choosePlaylist() throws Throwable {
        WebElement myPlaylist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'SatyTest')]"));
        elementToBeClickable(myPlaylist);
        myPlaylist.click();
    }

    public void verifyAddSongNotification() throws Throwable {
        WebElement notification = driver.findElement(By.xpath("//div[@class='success show']"));
        elementToBeClickable(notification);
        String notificationText = notification.getText();
        Assert.assertEquals("Added 1 song into \"SatyTest.\"", notificationText);
        System.out.println("Song added to the playlist");

    }
}
