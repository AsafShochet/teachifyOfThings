package wrappers;

import com.pubnub.api.Callback;
import com.pubnub.api.Pubnub;
import com.pubnub.api.PubnubError;
import com.pubnub.api.PubnubException;

import java.io.IOException;

/**
 * Created by Asaf.Shochet on 2/29/2016.
 */
public class PubNubWrapper {

    public PubNubWrapper(String sessionId) {
        final Pubnub pubnub = new Pubnub(sessionId, sessionId);

        try {
            pubnub.subscribe("my_channel", new Callback() {
                        @Override
                        public void connectCallback(String channel, Object message) {
                            System.out.println("connected to pubnub");
                            pubnub.publish("my_channel", "Hello from the PubNub Java SDK", new Callback() {
                            });
                        }

                        @Override
                        public void disconnectCallback(String channel, Object message) {
                            System.out.println("SUBSCRIBE : DISCONNECT on channel:" + channel
                                    + " : " + message.getClass() + " : "
                                    + message.toString());
                        }

                        public void reconnectCallback(String channel, Object message) {
                            System.out.println("SUBSCRIBE : RECONNECT on channel:" + channel
                                    + " : " + message.getClass() + " : "
                                    + message.toString());
                        }

                        @Override
                        public void successCallback(String channel, Object message) {
                            System.out.println("SUBSCRIBE : " + channel + " : "
                                    + message.getClass() + " : " + message.toString());

                           // String action = "PLAY_AUDIO"; // LOCK_DEVICE, PLAY_AUDIO, OPEN_URL
                            String action = message.toString();
                            ActionPerformer actionPerformer = new ActionPerformer();
                            try {
                                actionPerformer.perform(action);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void errorCallback(String channel, PubnubError error) {
                            System.out.println("SUBSCRIBE : ERROR on channel " + channel
                                    + " : " + error.toString());
                        }
                    }
            );
        } catch (PubnubException e) {
            System.out.println(e.toString());
        }

    }
}

