public class Homework16 {
    @Test
    public void registrationNavigation() throws InterruptedException{

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement submit = driver.findElement(By.cssSelector("a[href="registration"]"))submit.click();

        Assert.assertEquals(driver.getCurrentUrl(), url);

        driver.quit();
    }
}