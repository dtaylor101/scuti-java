package com.scuti.networking;

import org.eclipse.jetty.websocket.api.Session;
import com.scuti.networking.gameserver.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static spark.Spark.*;



public class Server {

    public static int nextUserNumber = 1;
    public static Map<Session, String> userMap = new ConcurrentHashMap<>();

    public static void connect() {
        staticFileLocation("/public");
        webSocket("/websocket", GameServer.class);
        init();

    }


}
