/*
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="TestNG">
 <test name="Example Test" preserve-order="false">
  <classes>
//<class name="LoginTests"/>
 <class name="BaseTest"/>
<class name="Homework17"/>
</classes>
</test>
</suite>
*/

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

//import java.time.Duration;

public class Homework17 extends BaseTest{
    @Test
    public void addSongToPlaylist(){

        launchBrowser();
        navigateToPage();
        provideEmail("john.wolschleger@testpro.io");
        providePassword("te$t$tudentb49");
        clickSubmit();
      //clickAddToBtn();
        closeBrowser();

}
public void avatarDisplayed() throws InterruptedException {
    WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
    Assert.assertTrue(avatarIcon.isDisplayed());
}
public void searchSong(String name) throws InterruptedException {
    WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
    searchField.sendKeys(name);
    Thread.sleep(2000);
}
public void clickViewAllBtn() throws InterruptedException {
    WebElement viewAll = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
    viewAll.click();
    Thread.sleep(2000);
}
public void clickAddToBtn() throws InterruptedException {
    WebElement addTo = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
    addTo.click();
    Thread.sleep(2000);
}
public void verifySongToPlaylist() {
    WebElement notification = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
    Assert.assertTrue(notification.isDisplayed());
}
}







