package com.scuti.messages.incoming.user;

import com.scuti.Emulator;
import com.scuti.database.Database;
import com.scuti.messages.incoming.IncomingEvent;
import org.json.JSONObject;

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
                        output.put("packedId", 222);
                        output.put("isConnected", true);
                        this.session.getRemote().sendString(output.toString());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(Emulator.ERROR + "Unable to load catalog pages!");
        }
    }
}
