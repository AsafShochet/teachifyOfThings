package wrappers;

import java.io.File;
import java.io.IOException;

/**
 * Created by Asaf.Shochet on 2/29/2016.
 */
public class ActionPerformer {

    public void perform(String action) throws IOException {

        TeacherAction teacherAction = TeacherAction.valueOf(action);
        switch (teacherAction){
            case LOCK_DEVICE:
                ComputerLocker computerLocker = new ComputerLocker();
                computerLocker.lockComputer();
                break;
            case OPEN_URL:
                ChromeWrapper chromeWrapper = new ChromeWrapper();
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
        }

    }
}
