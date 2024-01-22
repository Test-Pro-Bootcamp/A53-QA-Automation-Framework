package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    //Elements Locators Using Page Factory
    @FindBy(css = "[type='email']")
    WebElement emailTextField;
    @FindBy(css = "[type='password']")
    WebElement passwordTextField;
    @FindBy(css = "[type='submit']")
    WebElement loginButton;


    //Element Locators
    //String emailFieldCssSelector = "input[type='email']";
    By emailField = By.cssSelector("input[type='email']");

    By passwordField = By.cssSelector("input[type='password']");

    By submitBtn = By.cssSelector("button[type='submit']");

    //Page Methods Using Page Factory
    //public void provideEmailToLogin(String email){
    public LoginPage provideEmailToLogin(String email){
        emailTextField.sendKeys(email);
        return this;
    }
    //public void providePasswordToLogin(String password){
    public LoginPage providePasswordToLogin(String password){
        passwordTextField.sendKeys(password);
        return this;
    }
    //public void clickSubmitToLogin(){
    public LoginPage clickSubmitToLogin(){
        loginButton.click();
        return this;
    }

    //Page Methods

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
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        //System.out.println("Login button clicked");
    }

}
