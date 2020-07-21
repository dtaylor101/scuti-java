package com.scuti.networking.gameserver;

import com.scuti.messages.MessageManager;
import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;
import org.json.JSONObject;

import java.io.*;
import java.sql.SQLException;

@WebSocket
public class GameServer {

    private String sender, msg;

    @OnWebSocketConnect
    public void onConnect(Session user) throws IOException, SQLException {


        user.getRemote().sendString(String.valueOf(new JSONObject()
                .put("message", "la cité ma gueule")
        ));
    }

    @OnWebSocketClose
    public void onClose(Session user, int statusCode, String reason) {


    }

    @OnWebSocketMessage
    public void onMessage(Session user, String message) throws SQLException, IOException {
        MessageManager.messageHandler(message, user);
    }


}
