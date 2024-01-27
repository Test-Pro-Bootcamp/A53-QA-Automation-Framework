package pagefactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(css = "input[type='email']")
    WebElement emailField;
    @FindBy(css = "input[type='password']")
    WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    WebElement submitBtn;
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Fluent interface
    public LoginPage provideEmail(String email) {
      emailField.sendKeys(email);
      return this;
    }
    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmit() {
        click(submitBtn);
        return this;
    }

}


