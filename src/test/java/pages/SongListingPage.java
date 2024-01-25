package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SongListingPage extends BasePage {

        private CharSequence name;

        public SongListingPage(WebDriver givenDriver) {
            super(givenDriver);
        }

        public void searchSong(String name) {
        }

        @FindBy(css = "input[type='search']")
        public WebElement searchField;

        @FindBy(css = "button[data-test='view-all-songs-btn']")
        public WebElement viewAllBtn;

        @FindBy(xpath = "//section[@id='songResultsWrapper']//tr[@class='song-item'][1]")
        public WebElement firstSongResult;

        @FindBy(css = "button[class='btn-add-to']")
        public WebElement addToBtn;

        @FindBy(xpath = "//section[@id='songResultsWrapper']//li[contains(text(),'Homework')]")
        public WebElement playlist;

        public void searchSong() {
            searchField.sendKeys(name);
        }

        public void clickViewAllBtn() {
            viewAllBtn.click();
        }

        public void selectFirstSongResult() {
            firstSongResult.click();
        }

        public void clickAddToBtn() {
            addToBtn.click();
        }

        public void choosePlaylist() {
            playlist.click();
        }

        public String getAddToPlaylistSuccessMsg() {
            WebElement notification = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
            Assert.assertTrue(notification.isDisplayed());
            return notification.getText();
        }
}