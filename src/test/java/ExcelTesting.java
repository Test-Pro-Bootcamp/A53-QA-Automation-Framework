import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ExcelTesting extends BaseTest{

    @Test(dataProvider = "excel-data")
    public void loginWithExcelData(String email, String password){
        try{
            navigateToUrl(url);
            Thread.sleep(2000);
            provideEmail(email);
            providePassword(password);
            Thread.sleep(5000);

            clickSubmit();
            Thread.sleep(2000);

            WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
            Assert.assertTrue(avatar.isDisplayed());

        } catch(Exception e){
            System.out.println("Unable to login with Excel Data for an unknown reason." + e);
        }
    }

  /*  @Test(dataProvider = "excel-data")
    public void compareExcelData(String email, String password){

       String emailArray [] = {email, password};
       System.out.println(Arrays.toString(emailArray));

    }

    @Test(dataProvider = "excel-data")
    public void printData(){

    }
*/

}
