import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {

    @Test (dataProvider = "IncorrectLoginData", dataProviderClass = BaseTest.class, enabled = true, priority = 0, description = "Login with invalid email and valid password")
    public void loginInvalidEmailValidPassword(String email, String password) throws InterruptedException {

        provideEmail(email);
        providePassword(password);
        clickSubmit();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test (dataProvider = "IncorrectLoginData", dataProviderClass = BaseTest.class)
    public void loginEmptyEmailPassword(String email, String password) throws InterruptedException {
        provideEmail(email);
        providePassword(password);
        clickSubmit();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    
    @Test (enabled = true, priority = 1, description = "Login with valid email and valid password")
    public void loginValidEmailPassword(){

        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        isAvatarDisplayed();
    }

    @Test (enabled = true, priority = 3, description = "Login with valid email and empty password")
    public void loginValidEmailEmptyPassword() throws InterruptedException {

        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("");
        clickSubmit();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
    }
    public void isAvatarDisplayed() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test
    public void renamePlaylist() throws InterruptedException {
        String updatedPLMsg = "Updated playlist \"Sample Playlist.\"";

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Actions action = new Actions(driver);
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        action.doubleClick(playlistElement).perform();

        WebElement playlistImput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[class='editing']")));
        playlistImput.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistImput.sendKeys("Sample Playlist");
        playlistImput.sendKeys(Keys.ENTER);

        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[class='editing']")));
        String getRenameMsg = notification.getText();

        Assert.assertEquals(getRenameMsg, updatedPLMsg);

                   }
}