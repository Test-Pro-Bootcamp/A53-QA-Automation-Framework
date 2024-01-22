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

    //Page Elements
    By userAvatarIcon = By.cssSelector("img.avatar");

    By allSongsList = By.cssSelector("li a.songs");

    //Page Methods
    public WebElement getUserAvatarIcon(){
        return findElementUsingByLocator(userAvatarIcon);
    }

    //Element Locator
    //By playlistInputField = By.cssSelector("[name='name']");
    //By notificationRenamePlaylistSuccessMsg = By.cssSelector("div.success.show");

    public void enterNewPlaylistName(String newName, By locator){
//        WebElement playlistInputField =
//                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        //clear does not work since element has an attribute of required.
        findElementUsingByLocator(locator).sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        findElementUsingByLocator(locator).sendKeys(newName);
        findElementUsingByLocator(locator).sendKeys(Keys.ENTER);
        System.out.println("New Playlist name is entered");
    }
    public String getRenamePlaylistSuccessMsg(By locator){
        return findElementUsingByLocator(locator).getText();
    }

    //allSongs
    public WebElement allSongsList(){
        return findElementUsingByLocator(allSongsList);
    }
    public void goToAllSongsList(){
        findElementUsingByLocator(allSongsList).click();
    }


}
