import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTest extends BaseTest{

    @Test
    public void changeProfileName() throws InterruptedException {
        //Login
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        //Navigate to Profile Page
        clickOnAvatar();
        Thread.sleep(2000);
        //Random new Name
        String randomNewName = generateRandomName();
        Thread.sleep(2000);
        //Provide Current Password
        provideCurrentPassword("te$t$tudent");
        Thread.sleep(2000);
        //Provide new Random Name
        provideNewName(randomNewName);
        Thread.sleep(2000);
        //Click on the save button.
        clickSave();
        Thread.sleep(4000);
        //Assertion
        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(), randomNewName);
    }

    //Helper Methods
    //Navigate to Profile Page
    public void clickOnAvatar(){
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }

    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public void provideCurrentPassword(String password){
        WebElement currentPasswordField = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPasswordField.clear();
        currentPasswordField.sendKeys(password);
    }

    public void provideNewName(String newName){
        WebElement profileNameField = driver.findElement(By.cssSelector("[name='name']"));
        profileNameField.clear();
        profileNameField.sendKeys(newName);
    }

    public void clickSave(){
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

}
