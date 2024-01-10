import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException {
        provideEmail("utku.aktas94@testpro.io");
        providePassword("ekga9uf6");
        clickSubmit();
        isLoggedIn();
        Thread.sleep(1000);
        clickOnThePlaylistAndDelete("December");


    }

}
