import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class Homework16Test extends BaseTest {
    @Test
    public void registrationNavigation() {

        String url = "https://qa.koel.app/";
        getThreadLocal().get(url);
        getThreadLocal().findElement(By.xpath("//a[@href='registration']")).click();
        Assert.assertEquals(getThreadLocal().getCurrentUrl(), "https://qa.koel.app/registration");
    }
}