package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {
    public LoginPage (WebDriver givenDriver) {
        super(givenDriver);
    }

    //selectors
    @FindBy(css = "input[type='email']")
    private WebElement emailField;

    @FindBy(css = "input[type='password']")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy(css = "img[class='avatar']")
    private WebElement avatarIcon;

    public void provideEmail (String email) {
        emailField.sendKeys(email);
    }
    public void providePassword (String password) {
        passwordField.sendKeys(password);
    }
    public void clickSubmit () {
        submitButton.click();
    }

    public void loginWithValidCredentials () {
        provideEmail("vlad.kashchuk@testpro.io");
        providePassword("Q4sNKxVN");
        clickSubmit();
        Assert.assertTrue(findElementByLocator(avatarIcon).isDisplayed());
    }
}
