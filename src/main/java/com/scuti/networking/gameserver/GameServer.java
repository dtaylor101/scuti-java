package com.scuti.networking.gameserver;

import com.scuti.App;
import com.scuti.networking.Server;
import com.scuti.networking.*;
import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;
import org.json.JSONObject;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

@WebSocket
public class GameServer {

    private String sender, msg;

    @OnWebSocketConnect
    public void onConnect(Session user) throws Exception {
        String username = "User" + Server.nextUserNumber++;
        System.out.println(username + " joined the server");
    }

    @OnWebSocketClose
    public void onClose(Session user, int statusCode, String reason) {
        System.out.println("Somebody left :(");
    }

    @OnWebSocketMessage
    public void onMessage(Session user, String message) {
        if(message.equals("openCatalog")) {
            System.out.println(message);
            try {
                user.getRemote().sendString(String.valueOf(new JSONObject()
                        .put("canOpenCatalog", "true")
                ));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(message.equals("openNavigator")) {
            System.out.println(message);
            try {
                user.getRemote().sendString(String.valueOf(new JSONObject()
                        .put("canOpenNavigator", "true")
                ));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Get:" + message);
        }

    }

}
