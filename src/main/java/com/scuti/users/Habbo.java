package com.scuti.users;

import com.scuti.items.Item;
import com.scuti.rooms.Room;
import com.scuti.rooms.RoomTile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Habbo {
    private final int id;
    private String username;
    private int credits;
    private int pixels;
    private int diamonds;
    private final HashMap<Integer, Item> inventory = new HashMap<Integer, Item>();
    private Room room;
    private int x;
    private int y;
    private int z;
    private String sso;

    public Habbo(ResultSet set) throws SQLException {
        // TODO: create a load function
        this.id = set.getInt("id");
        this.username = set.getString("username");
        this.credits = set.getInt("credits");
        this.pixels = set.getInt("pixels");
        this.diamonds = set.getInt("diamonds");
    }

    public boolean checkSso() {
        return false;
    }

    public String getSso() {
        return this.sso;
    }

    public HashMap<Integer, Item> getInventory() {
        return this.inventory;
    }

    public Room getCurrentRoom() {
        return this.room;
    }

    public void goToRoom(Room room) {
        this.room = room;
        room.getUsers().put(this.getId(), this);
    }

    public int getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public int getCredits() {
        return this.credits;
    }

    public void addCredits(int x) {
        this.credits = this.credits + x;
    }

    public int getPixels() {
        return this.pixels;
    }

    public void addPixels(int x) {
        this.pixels = this.pixels + x;
    }

    public int getDiamonds() {
        return this.diamonds;
    }

    public void addDiamonds(int x) {
        this.diamonds = this.diamonds + x;
    }

    public int getX() { return this.x; }

    public int getY() { return this.y; }

    public int getZ() { return this.z; }

    //TODO: pathfinder... lol :c
    public void goToTile(RoomTile tile) {

    }
}
