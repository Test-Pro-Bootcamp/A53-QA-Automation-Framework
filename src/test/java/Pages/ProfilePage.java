package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.UUID;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver givenDriver){super(givenDriver);}

//    @FindBy(css = "img.avatar")
//    private WebElement avatarIcon;
    @FindBy(css = "[name='name']")
    private WebElement profileName;
    @FindBy(css = "div.success.show")
    private WebElement successMsg;
    private By bysuccessMsg = By.cssSelector("div.success.show");


    By avatarIcon = By.cssSelector("img.avatar");
    By currentPasswordField = By.cssSelector("[name='current_password']");
    By profileNameField = By.cssSelector("[name='name']");
    By saveButton = By.cssSelector("button.btn-submit");
    public ProfilePage clickOnAvatar(){
        //wait.until(ExpectedConditions.elementToBeClickable(avatarIcon)).click();
        findElementUsingByLocator(avatarIcon).click();
        return this;
    }
    public String generateRandomName(){return UUID.randomUUID().toString().replace("-", "");}

    public void provideCurrentPassword(String password){
        findElementUsingByLocator(currentPasswordField).sendKeys(password);}

    public void provideNewName(String newName){
        //findElementUsingByLocator(profileNameField).sendKeys(newName);
        wait.until(ExpectedConditions.elementToBeClickable(profileName)).clear();
        profileName.sendKeys(newName);
        //System.out.println("New random name provided");
    }

    public void clickSave(){
        findElementUsingByLocator(saveButton).click();
        //System.out.println("Change profile name save button clicked");
    }

//   // public String getRenameSuccessMsg(By locator){
//        return findElementUsingByLocator(locator).getText();
//    }

    public boolean getSuccessPopUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bysuccessMsg));
        return successMsg.isDisplayed();
    }


}




