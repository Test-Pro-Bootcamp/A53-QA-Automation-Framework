package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Element Locators using page factory
    @FindBy(css = "input[type='email']")
    WebElement emailField;
    @FindBy(css = "input[type='password']")
    WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    WebElement submitBtn;
    @FindBy(xpath = "//span[@class='name']")
    WebElement yourMusic;

    // Methods using Selenium Page Factory.
    public LoginPage provideEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit(){
        submitBtn.click();
        return this;
    }
    public boolean verifyLogin() throws Throwable {
        boolean status = yourMusic.isEnabled();
        Assert.assertTrue(status);
        return status;
    }
    public void loginWithValidCredentials() {
        provideEmail("burul.satybaeva@testpro.io");
        providePassword("Lulkerup7710%");
        clickSubmit();
    }
}
