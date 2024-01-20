package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    //Element Locators using Page Factory
    @FindBy(css = "input[type='email']")
    WebElement emailTextField;
    @FindBy(css = "input[type='password']")
    WebElement passwordTextField;
    @FindBy(css = "button[type='submit']")
    WebElement loginButton;

    //Element Locators
    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");

    // Page Methods using Selenium Page Factory.
    public LoginPage provideEmailToLogin(String email){
        emailTextField.sendKeys(email);
        return this;
    }

    public LoginPage providePasswordToLogin(String password){
        passwordTextField.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmitBtnToLogin(){
        loginButton.click();
        return this;
    }


    //Page Methods using POM Pattern
    public void provideEmail(String email){
        findElementUsingByLocator(emailField).sendKeys(email);
    }

    public void providePassword(String password){
        findElementUsingByLocator(passwordField).sendKeys(password);
    }

    public void clickSubmit(){
        findElementUsingByLocator(submitBtn).click();
    }

    public void login(){
        provideEmail("andrew.simmons@testpro.io");
        providePassword("Andrew.Simmons24");
        clickSubmit();
    }
}
