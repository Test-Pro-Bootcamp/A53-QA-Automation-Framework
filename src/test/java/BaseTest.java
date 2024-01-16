import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.List;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setupBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }



    void navigateTo(String url) {
    driver.get(url);
    }
    void loginToPlayer(String emailAddr, String password) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(emailAddr);

        WebElement pwField = driver.findElement(By.cssSelector("input[type='password']"));
        pwField.clear();
        pwField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }

    void searchSong(String songName) {
        WebElement searchField = driver.findElement(By.cssSelector("input[type=search]"));
        searchField.clear();
        searchField.sendKeys(songName);
        WebElement viewAll = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAll.click();
    }

    void addSongToPlaylist(int listIndex,String playlist) throws InterruptedException {
        List<WebElement> searchResultList = driver.findElements(By.cssSelector("#songResultsWrapper .song-item"));
        WebElement soughtSong = searchResultList.get(listIndex);
        soughtSong.click();
        WebElement addSongButton = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        addSongButton.click();
        List<WebElement> availablePlaylists = driver.findElements(By.cssSelector("section[id='songResultsWrapper'] li"));
        for (WebElement soughtPlaylist:availablePlaylists) {
            if (soughtPlaylist.getText().contains(playlist)) {
                soughtPlaylist.click();
            }
        }
        WebElement confirmationBanner = driver.findElement(By.cssSelector("[class='success show']"));
        Assert.assertTrue(confirmationBanner.isDisplayed());
    }

    void clickNextSong() {
        WebElement nextSongBtn = driver.findElement(By.cssSelector("[title='Play next song']"));
        nextSongBtn.click();
    }

    void clickPlay() {
        WebElement playButton = driver.findElement(By.cssSelector("[title='Play or resume']"));
        playButton.click();

    }
}