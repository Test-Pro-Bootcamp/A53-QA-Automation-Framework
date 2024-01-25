package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    //Page Locators
    By userAvatarIcon = By.cssSelector("img.avatar");




    //Page Methods
    public WebElement getUserAvatarIcon (){
        return findElementUsingByLocator(userAvatarIcon);
    }

    public WebElement allSongsList (){
        return findElementUsingByLocator(allSongsList);
    }

    public void doubleClickPlaylist(){
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
        System.out.println("double clicked on playlist.");
    }

    public void enterNewPlaylistName(String newPlaylistName){
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        //Clear does not work since element has an attribute of required.
        System.out.println("Playlist Located.");
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg() {
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();
    }




}
