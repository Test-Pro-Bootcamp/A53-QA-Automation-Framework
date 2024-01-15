import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.animation.model.KeyframeStyle;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;

public class Homework21 extends BaseTest{

    String newPlaylistName = "Homework21";

    @Test
    public void renamePlaylist() throws InterruptedException {
        loginToKoel("utku.aktas94@testpro.io","ekga9uf6");
//        Thread.sleep(2000);
        doubleClickOnThePlaylist();
//        Thread.sleep(2000);
        renameThePlaylist();
//        Thread.sleep(2000);
        //Check if name changed correctly
        Assert.assertEquals(nameChangeSuccessMsg(),("Updated playlist \""+newPlaylistName+".\""));
    }


    //Helper Methods
    void doubleClickOnThePlaylist(){
        WebElement playlist = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .cssSelector("li.playlist:nth-child(3)")));
        actions.doubleClick(playlist).perform();
    }

    void renameThePlaylist(){
        WebElement inputField = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .cssSelector("input[data-testid='inline-playlist-name-input']")));
        inputField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        inputField.sendKeys(newPlaylistName);
        inputField.sendKeys(Keys.ENTER);
    }

    public String nameChangeSuccessMsg(){
        WebElement notificatoinMsg = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .cssSelector("div.success.show")));
        return notificatoinMsg.getText();
    }
}
