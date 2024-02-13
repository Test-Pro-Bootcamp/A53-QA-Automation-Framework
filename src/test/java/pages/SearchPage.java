package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{


    //page Locators



    @FindBy(css="input[type='search']")
    private WebElement searchBar;

    @FindBy(css="button[data-test='view-all-songs-btn']")
    private   WebElement viewAllButton ;
    @FindBy(css=".search-results .items tr:nth-child(1)")
    private WebElement firstSong;
    @FindBy(css="button.btn-add-to")
    private   WebElement addToButton;
    @FindBy(css="songResultsWrapper .existing-playlists  li:nth-child(3)")
    private   WebElement addToPlaylist;
    @FindBy(css=".alertify-logs .success")
    private   WebElement successAlert;

    public SearchPage(WebDriver givenDriver){
        super(givenDriver);
    }

    public void choosePlaylist(String playlistName) {
        WebElement playlist = driver.findElement(By.xpath ("//*[@id='songResultsWrapper']//*[contains(text(), '" + playlistName + "')]"));
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

