package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    private By emailField = By.cssSelector("input[type='email']");
    private By passwordField = By.cssSelector("input[type='password']");
    private By submitButton = By.cssSelector("button[type='submit']");

    public void provideEmail(String email){
        findElementUsingByLocator(emailField).sendKeys(email);
    }
    public void providePassword(String password){
        findElementUsingByLocator(passwordField).sendKeys(password);
    }
    public void clickSubmit(){
        findElementUsingByLocator(submitButton).click();
    }

    public void login(){
        provideEmail("utku.aktas94@testpro.io");
        providePassword("ekga9uf6");
        clickSubmit();
    }

    public boolean isLoginBtnVisible(){
        return findElementUsingByLocator(submitButton).isDisplayed();
    }

}
