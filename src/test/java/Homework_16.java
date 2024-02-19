import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework_16 extends BaseTest{

    @Test
    public void registrationNavigation() {
        WebElement registration = driver.findElement(By.xpath("//a[text()='Registration / Forgot password']"));
        registration.click();
        WebElement registrationPage = driver.findElement(By.xpath("//h2[contains(text(),'Register new account or')]"));
        boolean status = registrationPage.isDisplayed();
        Assert.assertTrue(status);
        System.out.println("User is in the registration page");
    }
}
