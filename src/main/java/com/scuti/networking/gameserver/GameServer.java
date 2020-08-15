package com.scuti.networking.gameserver;

import com.scuti.Emulator;
import com.scuti.messages.incoming.IncomingEvent;
import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.SQLException;

@WebSocket
public class GameServer {

    @OnWebSocketConnect
    public void onConnect(Session user) throws Exception {
        System.out.println(user.getRemoteAddress().getHostName().concat(" is connected!"));
    }

    @OnWebSocketClose
    public void onClose(Session user, int statusCode, String reason) {
        System.out.println(user.getRemoteAddress().getHostName().concat(" is disconnected!"));
    }

    @OnWebSocketMessage
    public void onMessage(Session user, String message) throws IOException, IllegalAccessException, InstantiationException, SQLException {
        JSONObject msg = new JSONObject(message);

        int packet = msg.getInt("packetId");
        JSONObject data = msg.getJSONObject("data");

        //System.out.println(msg.toString());

        Class<? extends IncomingEvent> eventClass = Emulator.scuti().getIncomingEventManager().getEvents().get(packet);
        IncomingEvent event = eventClass.newInstance();
        event.data = data;
        event.session = user;
        event.handle();
    }

}
