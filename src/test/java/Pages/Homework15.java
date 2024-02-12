package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Homework15 {

    @Test
    public static void homework15() throws Throwable{
        WebDriverManager.chromedriver().setup();
        WebDriver Driver = new ChromeDriver();
        Driver.manage().window().maximize();
        Driver.get("https://qa.koel.app/");
        Thread.sleep(2000);
        Driver.get("https://testpro.io");
        System.out.println("Homework 15 is done");
    }
}
