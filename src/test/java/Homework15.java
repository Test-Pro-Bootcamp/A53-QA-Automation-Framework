public class Homework15 extends BaseTest {
    @Test
    public void openKoelpage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertTrue(driver.getCurrentUrl(), url);
        driver.quit();
    }
}
