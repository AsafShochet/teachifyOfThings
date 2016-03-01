package wrappers;

import java.io.IOException;

/**
 * Created by Asaf.Shochet on 2/29/2016.
 */
public class ChromeWrapper {
    public void openAndNavigateToUrl(String url) throws IOException {
        Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome "+url});
    }
}
