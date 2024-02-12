package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Page Locators
    private  By userAvatarIcon = By.cssSelector("img.avatar");

    private   By playButton = By.cssSelector("driver.findElement(By.cssSelector(\"span .play i\"));");


    //Page Methods
    public WebElement getUserAvatarIcon() {
        return findElementUsingByLocator(userAvatarIcon);
    }

}
