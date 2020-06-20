package com.scuti.rooms;

import com.scuti.App;
import com.scuti.database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class RoomManager {
    private static final HashMap<Integer, Room> rooms = new HashMap<Integer, Room>();

    public static void loadRooms() throws SQLException {
        System.out.println(App.LOADING + "Rooms...");
        try(Connection connection = Database.getDB().getConnection()) {
            try(Statement statement = connection.createStatement()) {
                try(ResultSet req = statement.executeQuery("SELECT * FROM rooms")) {
                    while(req.next()) {
                        rooms.put(req.getInt("id"), new Room(req));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(App.ERROR + "Rooms loader failed !");
        }
        System.out.println(App.SUCCESS + "Rooms loaded!");
    }

    public static HashMap<Integer, Room> getRoomsLoaded() {
        return rooms;
    }
}
