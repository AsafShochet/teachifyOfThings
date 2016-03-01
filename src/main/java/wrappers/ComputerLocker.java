package wrappers;

import java.io.IOException;

/**
 * Created by Asaf.Shochet on 2/29/2016.
 */
public class ComputerLocker {

    public void lockComputer() throws IOException {
        Runtime.getRuntime().exec("C:\\Windows\\System32\\rundll32.exe user32.dll,LockWorkStation");
    }
}
