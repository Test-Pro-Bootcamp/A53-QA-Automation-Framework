package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Element Locators
    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");

    By yourMusic = By.xpath("//span[@class='name']");

    //Page Methods
    public void provideEmail(String email) {
        findElementUsingByLocator(emailField).sendKeys(email);
    }

    public void providePassword(String password) {
        findElementUsingByLocator(passwordField).sendKeys(password);
    }

    public void clickSubmit() {
        findElementUsingByLocator(submitBtn).click();
    }

    public void verifyLogin() throws Throwable {
        WebElement music = findElementUsingByLocator(yourMusic);
        boolean status = music.isEnabled();
        Assert.assertTrue(status);
    }

    public void loginWithValidCredentials() {
        provideEmail("burul.satybaeva@testpro.io");
        providePassword("Lulkerup7710%");
        clickSubmit();
    }
}
