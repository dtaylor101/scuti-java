package com.scuti.messages.incoming.users;

import org.json.JSONObject;

public class RequestLoginEvent {

    public static void messageHandler(String message) {
        JSONObject jsonmsg = new JSONObject(message);
        System.out.println(jsonmsg.getJSONObject("data").getString("username") + " joined the server");
    }

    public void getUsername(String username) {

    }
}
