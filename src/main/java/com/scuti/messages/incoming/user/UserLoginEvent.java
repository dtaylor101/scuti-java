package com.scuti.messages.incoming.user;

import com.scuti.Emulator;
import com.scuti.database.Database;
import com.scuti.messages.incoming.IncomingEvent;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.*;

public class UserLoginEvent extends IncomingEvent {
    @Override
    public void handle() throws SQLException {
        // TODO: make sure the connection with SSO/Token
        String username = this.data.getString("username");
        try(Connection connection = Database.getDB().getConnection()) {
            try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ?")) {
                statement.setString(1, username);
                try(ResultSet set = statement.executeQuery()) {
                    if(set.next()) {
                        Emulator.scuti().getUserManager().loadHabbo(set);
                        JSONObject output = new JSONObject();
                        JSONObject data = new JSONObject();
                        JSONObject user = new JSONObject();

                        user.put("username", username);

                        data.put("isLogged", true);
                        data.put("user", user);

                        output.put("packetId", 222);
                        output.put("data", data);

                        System.out.println(output.toString());
                        this.session.getRemote().sendString(output.toString());
                    } else {
                        System.out.println(username.concat(" doesn't exist!"));
                    }
                    set.close();
                }
            }
        } catch (SQLException | IOException e) {
            System.out.println(Emulator.ERROR + "[UserLoginEvent] Cannot execute request!");
        }
    }
}
