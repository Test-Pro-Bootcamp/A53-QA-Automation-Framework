package pages;

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

    public LoginPage provideEmail (String email) {
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage providePassword (String password) {
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmit () {
        submitButton.click();
        return this;
    }

    //I find it less redundant to have one method like this in here than using Fluent Interface and call those 3 methods separately each time. Please let me know.
    public void loginWithValidCredentials () {
        provideEmail("vlad.kashchuk@testpro.io");
        providePassword("Q4sNKxVN");
        clickSubmit();
        Assert.assertTrue(findElement(avatarIcon).isDisplayed());
    }
}
