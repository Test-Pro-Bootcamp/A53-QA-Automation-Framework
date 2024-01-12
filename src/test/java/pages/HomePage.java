package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    private By userAvatarIcon = By.cssSelector("img.avatar");

    public WebElement getUserAvatar () {
        return findElement(userAvatarIcon);
    }
    private By playlistsGrid = By.xpath("//a[contains(text(), \"Homework17\")]");

    private By deletePlaylistBtn = By.xpath("//button[@class='del btn-delete-playlist']");

    private By deletePlaylistSuccessMsg = By.cssSelector("div.success.show");

    public void clickPlaylistsGrid() {
        click(playlistsGrid);
    }
    public void clickDeletePlaylistBtn() {
        click(deletePlaylistBtn);

    }
    public String getDeletePlaylistSuccessMsg() {
        return findElement(deletePlaylistSuccessMsg).getText();
    }
}