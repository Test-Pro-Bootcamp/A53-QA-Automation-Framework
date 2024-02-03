package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage{

    public RegistrationPage(WebDriver givenDriver){super(givenDriver);}

    @FindBy(css = "[href='registration']")
    private WebElement registrationLink;

    By registrationLinkBtn = By.cssSelector("[href='registration']");

    public void clickRegistrationLink(){
        findElementUsingByLocator(registrationLinkBtn).click();
    }
    public void registerBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(registrationLink)).click();
    }



}