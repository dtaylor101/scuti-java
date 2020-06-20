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
        System.out.println(App.LOADING + "Loading room manager...");
        long millis = System.currentTimeMillis();
        try(Connection connection = Database.getDB().getConnection()) {
            try(Statement statement = connection.createStatement()) {
                try(ResultSet req = statement.executeQuery("SELECT * FROM rooms")) {
                    while(req.next()) {
                        rooms.put(req.getInt("id"), new Room(req));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(App.ERROR + "Unable to load room manager!");
            System.exit(0);
        }
        System.out.println(App.SUCCESS + "Room manager -> OK! (" + (System.currentTimeMillis() - millis) + " MS)");
    }

    public static HashMap<Integer, Room> getRoomsLoaded() {
        return rooms;
    }
}
