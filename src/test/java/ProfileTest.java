import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTest extends BaseTest {

    @Test
    public void changeProfileName() throws InterruptedException{
        //Login
        provideEmail("utku.aktas94@testpro.io");
        providePassword("ekga9uf6");
        clickSubmit();
        Thread.sleep(2000);

        //Navigate to Profile Page
        clickOnAvatar();
        Thread.sleep(2000);

        String randomName = generateRandomName();
        provideNewName(randomName);
        Thread.sleep(2000);

        provideCurrentPassword("ekga9uf6");
        Thread.sleep(2000);

        clickSave();
        Thread.sleep(4000);


        WebElement actualProfileName = driver.findElement(By.cssSelector("span[class='name']"));
        Assert.assertEquals(actualProfileName.getText(),randomName);

    }

    public void clickOnAvatar(){
        WebElement avatarIcon  = driver.findElement(By.cssSelector("span[class='name']"));
        avatarIcon.click();
    }

    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public void provideNewName(String newName){
        WebElement profileNameField = driver.findElement(By.cssSelector("[name='name']"));
        profileNameField.clear();
        profileNameField.sendKeys(newName);
    }

    public void provideCurrentPassword(String password){
        WebElement currentPwField = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPwField.clear();
        currentPwField.sendKeys(password);
    }
    public void clickSave(){
        WebElement saveButton = driver.findElement(By.cssSelector("button[class='btn-submit']"));
        saveButton.click();
    }
}
