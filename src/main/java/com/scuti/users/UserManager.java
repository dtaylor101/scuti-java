package com.scuti.users;

import com.scuti.database.Database;

import java.sql.*;
import java.util.HashMap;

public class UserManager {
    private final HashMap<Integer, User> onlineUsers;

    public UserManager() {
        this.onlineUsers = new HashMap<Integer, User>();
    }

    public void loadHabbo(ResultSet set) throws SQLException {
        //try(Connection connection = Database.getDB().getConnection()) {
        //    try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE auth_ticket = ? AND id = ?")) {
        //        statement.setString(1, sso);
        //        statement.setInt(2, userId);
        //        try(ResultSet set = statement.executeQuery()) {
        //            if(set.next()) {
        //                this.onlineUsers.put(set.getInt("id"), new User(set));
        //            } else {
        //                System.out.println("USERID : " + userId + " -> failed to login!");
        //            }
        //        }
        //    }
        //} catch (Exception e) {
        //    System.out.println("LoadHabbo failed!");
        //}
        //TODO: Work with ID rather than username
        this.onlineUsers.put(set.getInt("id"), new User(set));
    }

    public HashMap<Integer, User> getOnlineUsers() {
        return this.onlineUsers;
    }

    public User getUser(int id) {
        return this.onlineUsers.get(id);
    }

    public User getUser(String username) {
        for(User user: onlineUsers.values()) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
