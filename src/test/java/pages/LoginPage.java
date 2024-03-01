package pages;

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

    public LoginPage loadLoginPage(){
        String url = "https://qa.koel.app/";
        driver.get(url);
        return this;
    }
    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword (String password){
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit(){
        submitBtn.click();
        return this;
    }

    public LoginPage clickRegistration(){
        registrationBtn.click();
        return this;
    }
    public LoginPage loginUsertoKoel(){
        loadLoginPage();
        provideEmail("william.chang@testpro.io");
        providePassword("te$tStudent1");
        clickSubmit();
        return this;
    }

}
