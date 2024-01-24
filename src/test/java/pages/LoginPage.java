package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Page Factory
    @FindBy(css = "[type='email']")
    WebElement emailTextField;
    @FindBy(css="[type='password']")
    WebElement passwordTextField;
    @FindBy(css="[type='submit']")
    WebElement loginButton;

    public LoginPage provideEmailToLogin(String email){
        emailTextField.sendKeys(email);
        return this;
    }
    public LoginPage providePasswordToLogin(String password){
        passwordTextField.sendKeys(password);
        return this;
    }
    public LoginPage clickLoginButton(){
        loginButton.click();
        return this;
    }

}
