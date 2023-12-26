<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">

<suite name="TestNG">

   <test name="Example Test" preserve-order="false">
      <classes>
         <class name="LoginTests"/>
         <class name="BaseTest"/>
         <class name="Homework17"/>
      </classes>
   </test>
</suite>
//Added above section
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17  extends BaseTest{
    @Test
    public void addSongToPlaylist(){

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String baseUrl = "https://qa.koel.app/";
        driver.get(baseUrl);

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("john.wolschleger@testpro.io");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudentb49");

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());

        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys("Pluto");

        WebElement viewAll = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAll.click();

        WebElement addTo = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addTo.click();

        WebElement verifySongToPlaylist = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
        Assert.assertTrue(verifySongToPlaylist.isDisplayed());

        driver.quit();
    }
}
