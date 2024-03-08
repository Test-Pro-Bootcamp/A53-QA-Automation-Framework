package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
public class ArtistPage extends BasePage{
    @FindBy (xpath="//a[@href='#!/artists']")
    protected WebElement artistLink;
    @FindBy (xpath= "//*[@id='artistsWrapper']//article[@title='AKMV-18']")
    protected WebElement songElement;
    public ArtistPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public ArtistPage loadArtistPage(){
        artistLink.click();
        return this;
    }
    public ArtistPage selectSongElement(){
        doubleClick(songElement);
        return this;
    }
}
