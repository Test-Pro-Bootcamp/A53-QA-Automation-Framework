package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePage {
    public LoginPage (WebDriver givenDriver) {
        super(givenDriver);
    }

    //selectors
    private By emailField = By.cssSelector("input[type='email']");
    private By passwordField = By.cssSelector("input[type='password']");
    private By submitButton = By.cssSelector("button[type='submit']");

    public void provideEmail (String email) {
        findElementByLocator(emailField).sendKeys(email);
    }
    public void providePassword (String password) {
        findElementByLocator(passwordField).sendKeys(password);
    }
    public void clickSubmit () {
        findElementByLocator(submitButton).click();
    }

    public void assertSuccessfulLogin () {
        Assert.assertTrue(findElementByLocator(By.cssSelector("img[class='avatar']")).isDisplayed());
    }
}
