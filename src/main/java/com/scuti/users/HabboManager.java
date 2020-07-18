package com.scuti.users;

import com.scuti.database.Database;

import java.sql.*;
import java.util.HashMap;

public class HabboManager {
    private static final HashMap<Integer, Habbo> onlineUsers = new HashMap<Integer, Habbo>();

    public static void loadHabbo(String sso, int userId) throws SQLException {
        try(Connection connection = Database.getDB().getConnection()) {
            try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE auth_ticket = ? AND id = ?")) {
                statement.setString(1, sso);
                statement.setInt(2, userId);
                try(ResultSet set = statement.executeQuery()) {
                    if(set.next()) {
                        onlineUsers.put(set.getInt("id"), new Habbo(set));
                    } else {
                        System.out.println("USERID : " + userId + " -> failed to login!");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("LoadHabbo failed!");
        }
    }

    public static HashMap<Integer, Habbo> getOnlineUsers() {
        return onlineUsers;
    }
}
