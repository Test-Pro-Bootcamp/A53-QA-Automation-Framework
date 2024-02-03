import org.testng.Assert;
import Pages.RegistrationPage;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest{

    @Test
    public void registrationNavigation(){

        RegistrationPage registrationPage= new RegistrationPage(getDriver());
        registrationPage.registerBtn();
        //registrationPage.clickRegistrationLink();

        String registrationUrl = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(),registrationUrl);
    }
}
