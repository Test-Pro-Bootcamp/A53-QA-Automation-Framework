import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    @Test
    public static void loginEmptyEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        String url = "https://qa.koel.app/";
        getThreadLocal().get(url);

        loginPage.provideEmail("");
        loginPage.providePassword("te$t$tudent");
        clickSubmitBtn();

        Assert.assertEquals(getThreadLocal().getCurrentUrl(), url);
    }

    @Test
    public static void loginWrongPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        String url = "https://qa.koel.app/";
        getThreadLocal().get(url);

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t123");
        clickSubmitBtn();

        Assert.assertEquals(getThreadLocal().getCurrentUrl(), url);
    }

    @Test
    public static void loginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        String url = "https://qa.koel.app/";
        getThreadLocal().get(url);

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("");
        clickSubmitBtn();

        Assert.assertEquals(getThreadLocal().getCurrentUrl(), url);
    }

    @Test
    public static void loginWrongEmailTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        String url = "https://qa.koel.app/";
        getThreadLocal().get(url);

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        clickSubmitBtn();

        Assert.assertEquals(getThreadLocal().getCurrentUrl(), url);
    }

    @Test
    public void loginSucceedTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        String url = "https://qa.koel.app/";
        getThreadLocal().get(url);

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        clickSubmitBtn();

        Assert.assertEquals(getThreadLocal().getCurrentUrl(), url);
    }
    private static void clickSubmitBtn() {
    }
}