package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "img[class='avatar']")
    WebElement userAvatarIcon;

    public boolean getUserAvatarIcon(){
        return wait.until(d->userAvatarIcon.isDisplayed());
//        return userAvatarIcon.isDisplayed();
    }
}