package com.scuti.networking.gameserver;

import com.scuti.App;
import com.scuti.database.Database;
import com.scuti.messages.MessageManager;
import com.scuti.networking.Server;
import com.scuti.catalog.*;
import com.scuti.rooms.RoomManager;
import com.scuti.networking.*;
import com.scuti.rooms.Room;
import jdk.nashorn.internal.parser.JSONParser;
import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;
import org.json.JSONObject;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.*;

@WebSocket
public class GameServer {

    private String sender, msg;

    @OnWebSocketConnect
    public void onConnect(Session user) throws IOException {
        user.getRemote().sendString(String.valueOf(new JSONObject()
                .put("message", "la cité ma gueule")
        ));
    }

    @OnWebSocketClose
    public void onClose(Session user, int statusCode, String reason) {
        System.out.println("Somebody left :(");
    }

    @OnWebSocketMessage
    public void onMessage(Session user, String message) {
        MessageManager.messageHandler(message);
        System.out.println(message);
    }


}
