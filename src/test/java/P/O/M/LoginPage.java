package P.O.M;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Element locators. Web Elements below vv

    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitButton = By.cssSelector("button[type='submit']");

    //Page Methods

    //Author - Vladislav Sadokha
    public void provideEmail(String email) {
        findElementUsingByLocator(emailField).sendKeys(email);
    }
    public void providePassword(String password) {
        findElementUsingByLocator(passwordField).sendKeys(password);
    }
    public void clickSubmit(String submit) {
        findElementUsingByLocator(submitButton).sendKeys(submit);
    }
    public void login() {
        provideEmail("demo@class.com");
        providePassword("te$t$udent");
        clickSubmit();
    }


}
























