import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver){ super(givenDriver);}
    void provideEmail(String email) {

        findElementUsingByLocator(emailFielf).sendKeys(email);}
    void providePassword(String password) {
        findElementUsingByLocator(passwordFielf).sendKeys(password);}
    void clickSubmit(){
        findElementUsingByLocator(submitButton).click();}
    public boolean isDisplayedButtonSubmit(){
        return findElementUsingByLocator(submitButton).isDisplayed();
    }
    public void loginValidEmailPassword() {
            provideEmail("dmitry.lobachev@testpro.io");
            providePassword("Chebyreki5!");
            clickSubmit();
        }
    }


