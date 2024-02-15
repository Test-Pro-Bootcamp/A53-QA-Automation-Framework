package P.O.M;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homework23 extends Serializers.Base {

    private WebDriver driver;

    // Using @FindBy to declare Web Elements
    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    // Constructor using initElements method of PageFactory
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods for interacting with the page

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    // Fluent Interface (optional)
    public LoginPage typeUsername(String username) {
        enterUsername(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        enterPassword(password);
        return this;
    }

    public DashboardPage submitLogin() {
        clickLoginButton();
        return new DashboardPage(driver);
    }
}

