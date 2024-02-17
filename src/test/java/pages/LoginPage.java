package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class LoginPage extends BasePage {

    @FindBy(css = "button[type='submit']")
    private WebElement submitButtonLocator;
    // Represents the submit button on the login form.

    @FindBy(css = "[type='email']")
    private WebElement emailField;
    // Represents the email input field on the login form.

    @FindBy(css = "[type='password']")
    private WebElement passwordField;
    // Represents the password input field on the login form.

    @FindBy(xpath = "//a[@href='registration']")
    private WebElement registrationLink;
    // Represents the registration link.

    @FindBy(css = ".fa-sign-out")
    private WebElement logOutLocator;
    // Represents the logout element for logging out of the system.


    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
// This is the constructor of the "LoginPage" class that accepts a WebDriver object as a parameter
// and invokes the constructor of the superclass (parent class) with this parameter.
// The constructor is used to initialize an object of the class when an instance is created.

    public LoginPage clickSubmitBtn() {
        submitButtonLocator.click();
        return this;
    }
// The "clickSubmitBtn" method clicks on the "submitButtonLocator" element (the submit button)
// and returns an instance of the "LoginPage" class.

    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }
// The "provideEmail" method enters the specified email address into the "emailField" input field
// and returns an instance of the "LoginPage" class.

    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }
// The "providePassword" method enters the specified password into the "passwordField" input field
// and returns an instance of the "LoginPage" class.

    public void provideLoginSucceed() {
        provideEmail("dmitry.lobachev@testpro.io");
        providePassword("Chebyreki5!");
        clickSubmitBtn();
    }
// The "provideLoginSucceed" method enters predefined email and password data
// and then clicks the submit button by using the "provideEmail", "providePassword", and "clickSubmitBtn" methods.

    public WebElement getRegistrationLink() {
        return registrationLink;
    }
// The "getRegistrationLink" method returns the "registrationLink" element (the registration link) as a "WebElement" object.

    public LoginPage clicklogOut() {
        logOutLocator.click();
        return this;
    }
// The "clicklogOut" method clicks on the "logOutLocator" element (the logout element)
// and returns an instance of the "LoginPage" class.
}


