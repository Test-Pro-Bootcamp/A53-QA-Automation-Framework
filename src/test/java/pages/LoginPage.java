package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath="//input[@type='email']")
    private WebElement emailField;
    @FindBy(xpath="//input[@type='password']")
    private WebElement passwordField;
    @FindBy(xpath="//button[@type='submit']")
    private WebElement submitBtn;

    @FindBy(xpath="//a[@href='registration']")
    private  WebElement registrationBtn;

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void loadLoginPage(){
        String url = "https://qa.koel.app/";
        driver.get(url);
    }
    public void provideEmail(String email) {
        emailField.sendKeys(email);
    }

    public void providePassword (String password){
        passwordField.sendKeys(password);
    }

    public void clickSubmit(){
        submitBtn.click();
    }

    public void clickRegistration(){
        registrationBtn.click();
    }

}
