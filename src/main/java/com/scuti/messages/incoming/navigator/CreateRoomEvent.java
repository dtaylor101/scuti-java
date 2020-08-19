package com.scuti.messages.incoming.navigator;

import com.scuti.Emulator;
import com.scuti.database.Database;
import com.scuti.messages.incoming.IncomingEvent;
import com.scuti.rooms.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateRoomEvent extends IncomingEvent {
    @Override
    public void handle() throws SQLException {
        try(Connection connection = Database.getDB().getConnection()) {
            try(PreparedStatement statement = connection.prepareStatement("INSERT INTO rooms (owner_id, name, description) VALUES (?, ?, ?)")) {
                statement.setInt(1, Emulator.scuti().gameClientManager().getClients().get(this.session).getId());
                statement.setString(2, this.data.getJSONObject("data").getString("roomName"));
                statement.setString(3, "");

                statement.execute();

                // ??
                try(ResultSet req = statement.executeQuery()) {
                    System.out.println(req.getString("name"));
                    Emulator.scuti().getRoomManager().getRoomsLoaded().put(req.getInt("id"), new Room(req));
                }
            }
        }
    }
}
