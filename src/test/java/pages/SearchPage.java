package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage{


    //page Locators

    private final   By searchBar = By.cssSelector("input[type='search']");
    private  final  By viewAllButton = By.cssSelector("button[data-test='view-all-songs-btn']");
    private  final By firstSong = By.cssSelector(".search-results .items tr:nth-child(1)");
    private final  By addToButton = By.cssSelector("button.btn-add-to");
    private  final By addToPlaylist = By.cssSelector("#songResultsWrapper .existing-playlists  li:nth-child(3)");
    private final  By successAlert = By.cssSelector(".alertify-logs .success");

    public SearchPage(WebDriver givenDriver){
        super(givenDriver);
    }

    public void choosePlaylist(String playlistName) {
        WebElement playlist = driver.findElement(By.xpath("//*[@id='songResultsWrapper']//*[contains(text(), '" + playlistName + "')]"));
        playlist.click();

    }

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

    public void clickableToButton(){
        findElementUsingByLocator(addToButton).click();
    }

    public void clickAddToPlaylist(){
        findElementUsingByLocator(addToPlaylist).click();
    }

    public WebElement findSuccessAlertMsg(){
        return findElementUsingByLocator(successAlert);
    }
}

