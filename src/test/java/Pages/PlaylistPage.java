package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlaylistPage  extends BasePage {

    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Element Locators using Page Factory
    @FindBy(css = "[href='#!/playlist/83406']")
    WebElement selectPlaylistUsingPageFactory;

    @FindBy(css = ".btn-delete-playlist")
    WebElement deletePlaylistBtnUsingPageFactory;


    //page Methods using selenium Factory
    public Pages.PlaylistPage selectPlaylistToDelete() {
        selectPlaylistUsingPageFactory.click();
        return this;
    }

    public Pages.PlaylistPage clickAndDeletePlaylist() {
        deletePlaylistBtnUsingPageFactory.click();
        return this;
    }



}




