package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

//    By avatarIcon = By.cssSelector("img.avatar");

    @FindBy(css = "img[class='avatar']")
    WebElement userAvatarIcon;

    public boolean getUserAvatarIcon(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        return wait.until(d->userAvatarIcon.isDisplayed());
//        return userAvatarIcon.isDisplayed();
    }

//    public boolean  getUserAvatarIcon(){
//        return findElementUsingByLocator(avatarIcon).isDisplayed();
//    }


}
