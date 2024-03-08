package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
public class AlbumPage extends BasePage{

    @FindBy (xpath="//a[@href='#!/albums']")
    protected WebElement albumLink;
    @FindBy (xpath= "//*[@id='albumsWrapper']//article[@title='Airbit by Makaih Beats']")
    protected WebElement songElement;
    public AlbumPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public AlbumPage loadAlbumPage(){
        albumLink.click();
        return this;
    }

    public AlbumPage selectSongElement(){
        doubleClick(songElement);
        return this;
    }
}
