package com.scuti.networking;

import com.scuti.networking.gameserver.*;
import static spark.Spark.*;

public class Server {
    public static void connect() {
        port(30000);
        webSocket("/", GameServer.class);
        init();
    }
}