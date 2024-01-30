package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public LoginPage (WebDriver givenDriver) {
        super(givenDriver);
    }

    //selectors
    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitButton = By.cssSelector("button[type='submit']");

    public void provideEmail (String email) {
        findElementByLocator(emailField).sendKeys(email);
    }
    public void providePassword (String password) {
        findElementByLocator(passwordField).sendKeys(password);
    }
    public void clickSubmit () {
        findElementByLocator(submitButton).click();
    }

    public void login (String emailAddress, String password) {
        provideEmail(emailAddress);
        providePassword(password);
        clickSubmit();
        
    }
}
