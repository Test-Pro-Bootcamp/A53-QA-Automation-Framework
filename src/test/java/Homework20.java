import org.testng.annotations.Test;

public class Homework20 extends BaseTest{

    @Test
    public void deletePlaylist() {
        provideEmail("utku.aktas94@testpro.io");
        providePassword("ekga9uf6");
        clickSubmit();
        isLoggedIn();

        clickOnThePlaylistAndDelete("December");
    }

}
