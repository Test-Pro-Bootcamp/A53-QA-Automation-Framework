import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW19 extends BaseTest{

    @Test
    public void deletePlaylist(){

        provideEmail("daria.huzhvii@testpro.io");
        providePassword("VutYN7Kv");
        clickSubmit();
        selectPlayList();
        xPlaylist();
        //confirm();
        Assert.assertTrue(confirmationMessage());




    }

    public void selectPlayList(){
        WebElement selectPlayList = driver.findElement(By.cssSelector("[href='#!/playlist/85556']"));
        selectPlayList.click();
    }

    public void xPlaylist(){
        WebElement xPlaylist = driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        xPlaylist.click();
    }

//    public void confirm(){
//        WebElement confirm = driver.findElement(By.cssSelector(".dialog .ok"));
//        confirm.click();
//    }

    public boolean confirmationMessage (){
        WebElement confirmationMessage = driver.findElement(By.cssSelector("[class='success show']"));
        return confirmationMessage.isDisplayed();
    }

}
