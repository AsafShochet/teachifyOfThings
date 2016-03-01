package wrappers;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
                            // publisher key: pub-c-88967b36-134b-4893-ad5e-ae4890495804
        String sessionId = "sub-c-a67e1e3a-df2a-11e5-8905-02ee2ddab7fe";
        if (args != null && args.length > 0){
            sessionId = args[0];
        }

        PubNubWrapper pubNumWrapper = new PubNubWrapper(sessionId);

    }
}
