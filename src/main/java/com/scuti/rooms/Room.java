package com.scuti.rooms;

import com.scuti.users.Habbo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Room {
    /** TODO: HashMap arrays for:
     * -> users in this room OK
     * -> items in this room
     * -> bots in this room
     * ...
    **/
    private final int id;
    private final String name;
    private final String description;
    private final int ownerId;
    private HashMap<Integer, Habbo> users;

    public Room(ResultSet req) throws SQLException {
        this.id = req.getInt("id");
        this.name = req.getString("name");
        this.description = req.getString("description");
        this.ownerId = req.getInt("owner_id");
    }

    public HashMap<Integer, Habbo> getUsers() {
        return this.users;
    }

    public void userEntry(Habbo user) {
        this.users.put(user.getId(), user);
        user.setCurrentRoom(this);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getOwnerId() {
        return this.ownerId;
    }
}
