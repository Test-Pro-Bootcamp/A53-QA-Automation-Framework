import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Instant;

public class HW20 extends BaseTest{

    @Test

    public void removePlaylist(){
        provideEmail("daria.huzhvii@testpro.io");
        providePassword("VutYN7Kv");
        clickSubmit();
        selectPlayList();
        xPlaylist();
        Assert.assertTrue(confirmationMessage());


    }

    public void selectPlayList(){
        WebElement selectPlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='#!/playlist/85571']")));
        selectPlayList.click();
    }
    public void xPlaylist(){
        WebElement xPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Delete this playlist']")));
        xPlaylist.click();
    }

    public boolean confirmationMessage (){
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='success show']")));
        return confirmationMessage.isDisplayed();
    }

}
