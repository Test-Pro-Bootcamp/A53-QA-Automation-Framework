package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "[type='email']")
    WebElement emailField;
    //By emailField = By.cssSelector("input[type='email']");
    @FindBy(css = "[type='password']")
    WebElement passwordField;
    //By passwordField = By.cssSelector("input[type='password']");
    @FindBy(css = "[type='submit']")
    WebElement submitBtn;
    //By submitBtn = By.cssSelector("button[type='submit']");

    public void provideEmail(String email) {
        emailField.sendKeys(email);
        //findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password) {
        passwordField.sendKeys(password);
        //findElement(passwordField).sendKeys(password);
    }
    public void clickSubmit() {
        submitBtn.click();
        //click(submitBtn);
    }

    public void login() {
        provideEmail("john.wolschleger@testpro.io");
        providePassword("te$t$tudentb49");
        clickSubmit();
    }
}
