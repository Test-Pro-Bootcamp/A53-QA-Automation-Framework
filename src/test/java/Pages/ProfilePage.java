package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.UUID;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver givenDriver){super(givenDriver);}


}


//public void clickOnAvatar(){
//    WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
//    avatarIcon.click();
//    //driver.get("https://qa.koel.app/#!/profile");
//}
//public String generateRandomName(){
//    return UUID.randomUUID().toString().replace("-", "");
//}
//public void provideCurrentPassword(String password){
//    WebElement currentPasswordField = driver.findElement(By.cssSelector("[name='current_password']"));
//    currentPasswordField.clear();
//    currentPasswordField.sendKeys(password);
//}
//public void provideNewName(String newName){
//    WebElement profileNameField = driver.findElement(By.cssSelector("[name='name']"));
//    profileNameField.clear();
//    profileNameField.sendKeys(newName);
//}
//public void clickSave(){
//    WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
//    saveButton.click();
//}