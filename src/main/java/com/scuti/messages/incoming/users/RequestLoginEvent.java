package com.scuti.messages.incoming.users;

import com.scuti.Emulator;
import com.scuti.Scuti;
import org.json.JSONObject;
import org.eclipse.jetty.websocket.api.*;

import java.io.IOException;
import java.sql.SQLException;

public class RequestLoginEvent {

    public static void messageHandler(String message, Session user) throws SQLException, IOException {
        /*
        JSONObject jsonmsg = new JSONObject(message);
        JSONObject data = jsonmsg.getJSONObject("data");
        int id = data.getInt("id");
        String sso = data.getString("ssoTicket");
        //if(Emulator.scuti().getUserManager().loadHabbo(sso, id)) {
            user.getRemote().sendString(String.valueOf(new JSONObject()
                    .put("connected", true)
            ));
        } else {
            System.out.println(Emulator.USER + "Unable to connect user id " + id);
            user.getRemote().sendString(String.valueOf(new JSONObject()
                    .put("connected", false)
            ));
        }
    }

    public void getUsername(String username) {
    */
    }
}
