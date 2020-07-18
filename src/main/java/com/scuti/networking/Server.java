package com.scuti.networking;

import org.json.JSONObject;
import org.eclipse.jetty.websocket.api.Session;
import spark.Spark;
import com.scuti.networking.gameserver.*;
import spark.TemplateEngine;
import spark.TemplateViewRoute;
import org.json.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
