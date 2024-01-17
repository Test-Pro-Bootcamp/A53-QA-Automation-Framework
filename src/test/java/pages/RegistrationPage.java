package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(xpath="//input[@type='email']" )
    private WebElement emailField;
    @FindBy(xpath="//button[@type='submit']")
    private WebElement submitBtn;


    public String getPageUrl(){
        return  "https://qa.koel.app/registration";
    }
    public void provideEmail(String email) {
        findElement(emailField).sendKeys(email);
    }

    public void clickSubmit(){
        findElement(submitBtn).click();
    }



}
