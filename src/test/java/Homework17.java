import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist(){
        loginToKoel("utku.aktas94@testpro.io","ekga9uf6");

        searchSong("Maarten Schellekens - The Little Match Girl (ft. Enlia)");

        addToPlaylist("December");

    }

    public void loginToKoel(String email, String pw){
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);

        WebElement pwField = driver.findElement(By.cssSelector("input[type='password']"));
        pwField.clear();
        pwField.sendKeys(pw);

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    public void searchSong(String musicName){

        WebElement searchField = driver.findElement(By.cssSelector("input[type=search]"));
        searchField.clear();
        searchField.sendKeys(musicName);

        WebElement viewAll = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAll.click();

        //First song is not selected
        //WebElement firstSongInTheList = driver.findElement(By.cssSelector("table.items tr:first-child"));
        WebElement firstSongInTheList = driver.findElement(By.cssSelector("table.items tr:nth-of-type(1)"));
        firstSongInTheList.click();
    }

    public void addToPlaylist(String playlistName){
        WebElement addToButton = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addToButton.click();

//        WebElement playlist = driver.findElement(By.cssSelector("li.playlist:contains('December')"));
        WebElement playlist = driver.findElement(By.xpath("//li[@class='playlist' and contains(text(), '" + playlistName + "')]"));
        playlist.click();

        WebElement warningMessage = driver.findElement(By.cssSelector("div[class='success']"));
        Assert.assertEquals(warningMessage.getText(),"Added 1 song into '"+playlistName+"'.");
    }
}
