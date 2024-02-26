package PageObject;

import org.testng.annotations.Test;

public class Homework_22 extends commonUtils {

    loginPage login = new loginPage();
    playSong music = new playSong();

    @Test
    public void playAndPauseSong() throws Throwable {
        login.loginToKoelApp();
        music.playTheSong();
        music.clickNextSong();
        music.pauseSong();
    }
}
