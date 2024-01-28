import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class Homework20Test extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        LoginPage login = new LoginPage(getThreadLocal());
        login.loginUsertoKoel();
        getThreadLocal().findElement(By.xpath("//li[@class='playlist playlist'][1]")).click();
        getThreadLocal().findElement(By.xpath("//button[@class='del btn-delete-playlist']")).click();


        WebDriverWait w = new WebDriverWait(getThreadLocal(), Duration.ofSeconds(3));

        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='success show']")));
        WebElement successPopup = getThreadLocal().findElement(By.xpath("//*[@class='success show']"));
        Assert.assertEquals(successPopup.getText(), "Deleted playlist \"NewPlaylist.\"");

    }
}