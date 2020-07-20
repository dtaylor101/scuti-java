package com.scuti.users;

import com.scuti.database.Database;

import java.sql.*;
import java.util.HashMap;

public class UserManager {
    private static final HashMap<Integer, User> onlineUsers = new HashMap<Integer, User>();

    public static void loadHabbo(String sso, int userId) throws SQLException {
        try(Connection connection = Database.getDB().getConnection()) {
            try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE auth_ticket = ? AND id = ?")) {
                statement.setString(1, sso);
                statement.setInt(2, userId);
                try(ResultSet set = statement.executeQuery()) {
                    if(set.next()) {
                        onlineUsers.put(set.getInt("id"), new User(set));
                    } else {
                        System.out.println("USERID : " + userId + " -> failed to login!");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("LoadHabbo failed!");
        }
    }

    public static HashMap<Integer, User> getOnlineUsers() {
        return onlineUsers;
    }

    public static User getUser(int id) {
        return onlineUsers.get(id);
    }
}
