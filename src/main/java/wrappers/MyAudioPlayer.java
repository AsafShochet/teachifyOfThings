package wrappers;

import java.io.File;
import java.io.IOException;

/**
 * Created by Asaf.Shochet on 2/29/2016.
 */
public class MyAudioPlayer {
    public void play(File path) throws IOException {
        Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start wmplayer " + path.getAbsolutePath()});
    }
}
