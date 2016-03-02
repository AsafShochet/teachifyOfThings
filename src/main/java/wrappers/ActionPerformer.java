package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Asaf.Shochet on 2/29/2016.
 */
public class ActionPerformer {

    public void perform(String action) throws IOException {

        TeacherAction teacherAction = TeacherAction.valueOf(action);
        ChromeWrapper chromeWrapper;
        switch (teacherAction){
            case LOCK_DEVICE:
                ComputerLocker computerLocker = new ComputerLocker();
                computerLocker.lockComputer();
                break;
            case OPEN_URL:
                chromeWrapper = new ChromeWrapper();
                chromeWrapper.openAndNavigateToUrl("https://www.youtube.com/embed/YgHrn2VFbvo?autoplay=1");
                break;
            case PLAY_AUDIO:
                MyAudioPlayer myAudioPlayer = new MyAudioPlayer();
                ClassLoader classLoader = getClass().getClassLoader();
                File file = new File(classLoader.getResource("song.mp3").getFile());
                myAudioPlayer.play(file);
                break;
            case SEND_EMAIL:
                SendEmail sendEmail = new SendEmail();
                String address = "asaf.shochet@timetoknow.com";
                sendEmail.sendMessage(address);
                break;
            case OPEN_WIKIPEDIA:
                chromeWrapper = new ChromeWrapper();
                List<String> presidentsUrls = Arrays.asList("https://he.wikipedia.org/wiki/%D7%A9%D7%9E%D7%A2%D7%95%D7%9F_%D7%A4%D7%A8%D7%A1", "https://he.wikipedia.org/wiki/%D7%A2%D7%96%D7%A8_%D7%95%D7%99%D7%A6%D7%9E%D7%9F", "https://he.wikipedia.org/wiki/%D7%96%D7%9C%D7%9E%D7%9F_%D7%A9%D7%96%D7%A8","https://he.wikipedia.org/wiki/%D7%99%D7%A6%D7%97%D7%A7_%D7%91%D7%9F-%D7%A6%D7%91%D7%99", "https://he.wikipedia.org/wiki/%D7%97%D7%99%D7%99%D7%9D_%D7%95%D7%99%D7%A6%D7%9E%D7%9F");
                String presidentUrl = presidentsUrls.get(new Random().nextInt(presidentsUrls.size()));
                chromeWrapper.openAndNavigateToUrl(presidentUrl);
                break;

        }

    }
}
