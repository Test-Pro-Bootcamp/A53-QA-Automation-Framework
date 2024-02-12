import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Parameters({"BaseUrl"})
    @Test
    public void navigateToKoelApp(String BaseUrl){
        navigateToUrl(BaseUrl);
        Assert.assertEquals(driver.getCurrentUrl(),BaseUrl);
        driver.quit();
    }
    @Test (dataProvider = "InvalidLoginData")
    //@Parameters({"BaseUrl"})
    public void loginInvalidEmailValidPassword(String email, String password) throws InterruptedException {

        navigateToPage();
        provideEmail(email);
        providePassword(password);
        clickSubmit();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }

    @Test (enabled = true, priority = 1, description = "Login with valid email and valid password")
    public void loginValidEmailPassword(){

        navigateToPage();
        provideEmail("constantin@moraresco.com");
        providePassword("Nastika20$");
        clickSubmit();
        isAvatarDisplayed();
    }

    @Test (enabled = true, priority = 3, description = "Login with valid email and empty password")
    public void loginValidEmailEmptyPassword() {

        navigateToPage();
        provideEmail("constantin@moraresco.com");
        providePassword("");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
    }

 }