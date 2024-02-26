package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class loginPage extends commonUtils {
    public void provideValidEmail(String email) {

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.sendKeys(email);
    }

    public void provideValidPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }

    public void loginToKoelApp() throws Throwable {
        provideValidEmail("burul.satybaeva@testpro.io");
        provideValidPassword("Lulkerup7710%");
        clickSubmit();
    }
    public void verifyLogin() throws Throwable{

    }

}
