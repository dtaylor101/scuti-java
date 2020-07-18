package com.scuti.messages.incoming.users;

import com.scuti.App;
import com.scuti.networking.Server;
import org.json.JSONObject;
import com.scuti.users.*;
import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.SQLException;

public class RequestLoginEvent {

    public static void messageHandler(String message, Session user) throws SQLException, IOException {
        JSONObject jsonmsg = new JSONObject(message);
        JSONObject data = jsonmsg.getJSONObject("data");
        int id = data.getInt("id");
        String sso = data.getString("ssoTicket");
        if(HabboManager.loadHabbo(sso, id)) {
            user.getRemote().sendString(String.valueOf(new JSONObject()
                    .put("connected", true)
            ));
        } else {
            System.out.println(App.USER + "Unable to connect user id " + id);
            user.getRemote().sendString(String.valueOf(new JSONObject()
                    .put("connected", false)
            ));
        }
    }

    public void getUsername(String username) {

    }
}
