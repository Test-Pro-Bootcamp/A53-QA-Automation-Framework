import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import java.time.Duration;

public class Homework23Test extends BaseTest {

    WebDriver driver;
    @BeforeTest
    public void setup(){
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void loginUser() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loadLoginPage();
        loginPage.provideEmail("william.chang@testpro.io");
        loginPage.providePassword("te$tStudent");
        loginPage.clickSubmit();
    }


    @Test
    public void deletePlaylist() {
       HomePage homePage = new HomePage(driver);
       homePage.selectPlaylistElement();
       homePage.clickDeletePlaylistBtn();
       Assert.assertTrue(homePage.successNotificationActive());
       Assert.assertEquals(homePage.getSuccessNotificationText(),"Deleted playlist \"NewPlaylist.\"");
    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}