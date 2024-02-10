import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homework20 extends BaseTest {

    public class deletePlaylist() {
        //Replace thread.sleep with WebDriverWait
        WebDriverWait wait = WebDriverWait(driver,10);
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector()));
    }
}

