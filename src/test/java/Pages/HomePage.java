package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Page Locators
    By userAvatarIcon = By.cssSelector("img.avatar");

    By playButton = By.cssSelector("driver.findElement(By.cssSelector(\"span .play i\"));");


    //Page Methods
    public WebElement getUserAvatarIcon() {
        return findElementUsingByLocator(userAvatarIcon);
    }

}