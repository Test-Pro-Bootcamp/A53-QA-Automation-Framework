import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest{

    @Test
    public void changeProfileName() throws InterruptedException {

        navigateToPage();
        provideEmail("azahn007@gmail.com");
        providePassword("Koelpass");
        clickSubmit();

        Thread.sleep( 2000);
        clickAvatarIcon();

        String randomName = generateRandomName();

        provideCurrentPassword("Koelpass");
        provideProfileName(randomName);
        clickSaveButton();

        Thread.sleep( 2000);
        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(), randomName);




    }



}
