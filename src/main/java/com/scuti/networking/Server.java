package com.scuti.networking;

import org.json.JSONObject;
import spark.*;
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
    static Map<Session, String> userUsernameMap = new ConcurrentHashMap<>();

    public static void connect() {
        staticFileLocation("/public");
        webSocket("/websocket", GameServer.class);
        init();

    }


}
