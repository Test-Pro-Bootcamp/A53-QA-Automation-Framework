package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    /*
     driver.findElement(By.xpath("//li[@class='playlist playlist'][1]")).click();
        driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']")).click();

        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(3));
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='success show']"
     */
    @FindBy(xpath="//li[@class='playlist playlist'][1]")
    private WebElement playlistElement;
    @FindBy(xpath="//button[@class='del btn-delete-playlist']")
    private WebElement deletePlaylistBtn;
    @FindBy(xpath="//*[@class='success show']")
    private WebElement successNotification;
    @FindBy(xpath="//p[@class='msg']")
    private WebElement deleteNotification;
    @FindBy(xpath="//button[@class='ok']")
    private WebElement deleteNotificationOkBtn;

    public boolean isSuccessNotificationActive;
    public String successNotificationText;
    public boolean isDeletePlaylistNotification;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
        isSuccessNotificationActive = false;
        successNotificationText = " ";
    }

    public HomePage selectPlaylistElement(){
        playlistElement.click();
        return this;
    }
    public HomePage clickDeletePlaylistBtn(){
        deletePlaylistBtn.click();
        return this;
    }
    public HomePage clickdeleteNotificationOkBtn(){
        deleteNotificationOkBtn.click();
        getSuccessNotification();
        return this;
    }

    public HomePage getDeleteNotification(){
        try {
            if (deleteNotification.isDisplayed()){
               return clickdeleteNotificationOkBtn();
            }
        }catch (Exception e){
            getSuccessNotification();
            System.out.println("No delete notification");
        }
        return this;
    }

    public HomePage getSuccessNotification(){
      WebElement successNotificationLocal = findElement(successNotification);
        isSuccessNotificationActive = successNotificationLocal.isDisplayed();
        successNotificationText = successNotificationLocal.getText();
        return this;
    }

}
