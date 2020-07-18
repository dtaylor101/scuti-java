package com.scuti.messages;

import com.scuti.messages.incoming.users.*;
import org.json.*;


public class MessageManager {

    private String action;

    public static void messageHandler(String message) {
        if(parseMessage(message).equals("RequestLoginEvent")) {
            RequestLoginEvent.messageHandler(message);
        }
    }
    public static String parseMessage(String message) {
        JSONObject jsonmsg = new JSONObject(message);
        String action = jsonmsg.getString("action");
        return action;
    }
}
