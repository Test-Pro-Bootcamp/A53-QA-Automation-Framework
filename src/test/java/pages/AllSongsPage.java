package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class AllSongsPage extends BasePage{
    public AllSongsPage (WebDriver givenDriver) {super(givenDriver);}
    @FindBy(css = "#songsWrapper table.items tr")
    private List<WebElement> allSongs;
    @FindBy(css = "[title='Click for a marvelous visualizer!']")
    private WebElement visualizer;

    public void playFirstSong() {
        actions.doubleClick(allSongs.get(0)).perform();
        Assert.assertTrue(findElement(visualizer).isDisplayed());
    }

    public void playLastSong() {
        actions.doubleClick(allSongs.get(allSongs.size()-1)).perform();
        Assert.assertTrue(findElement(visualizer).isDisplayed());
    }


}
