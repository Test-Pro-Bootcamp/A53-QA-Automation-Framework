import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    @parameters({"BaseUrl"})
    public String url = "https://qa.koel.app/";
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    protected void provideEmail() {
        // stuff
    }

    protected void providePassword() {
        // stuff
    }

    protected void clickSubmit() {
        // stuff
    }


}