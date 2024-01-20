package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage{

    public SearchPage(WebDriver givenDriver){
        super(givenDriver);
    }

    //page Locators
    By searchBar = By.cssSelector("input[type='search']");
    By viewAllButton = By.cssSelector("button[data-test='view-all-songs-btn']");
    By firstSong = By.cssSelector(".search-results .items tr:nth-child(1)");
    By addToButton = By.cssSelector("button.btn-add-to");
    By addToPlaylist = By.cssSelector("#songResultsWrapper .existing-playlists  li:nth-child(5)");
    By successAlert = By.cssSelector(".alertify-logs .success");

    //page Methods
    public void findSearchBar(String songTitle) {
        findElementUsingByLocator(searchBar).sendKeys(songTitle);
    }

    public void clickViewAllButton(){
        findElementUsingByLocator(viewAllButton).click();
    }

    public void clickFirstSong(){
        findElementUsingByLocator(firstSong).click();
    }

    public void clickaddToButton(){
        findElementUsingByLocator(addToButton).click();
    }

    public void clickAddToPlaylist(){
        findElementUsingByLocator(addToPlaylist).click();
    }

    public WebElement findSuccessAlertMsg(){
        return findElementUsingByLocator(successAlert);
    }
}
