package pagefactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "img[class='avatar']")
    WebElement avatarIcon;
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public boolean isAvatarDisplayed(){
        return avatarIcon.isDisplayed();
    }
}


