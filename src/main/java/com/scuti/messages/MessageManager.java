package com.scuti.messages;

import com.scuti.messages.incoming.users.*;
import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;
import org.json.*;

import java.io.IOException;
import java.sql.SQLException;


public class MessageManager {

    private String action;

    public static void messageHandler(String message, Session user) throws SQLException, IOException {
        if(parseMessage(message).equals("RequestLoginEvent")) {
            RequestLoginEvent.messageHandler(message, user);
        }
    }
    public static String parseMessage(String message) {
        JSONObject jsonmsg = new JSONObject(message);
        String action = jsonmsg.getString("action");
        return action;
    }
}
