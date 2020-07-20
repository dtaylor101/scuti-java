package com.scuti.users;

import com.scuti.items.Item;
import com.scuti.items.ItemManager;
import com.scuti.rooms.Room;
import com.scuti.rooms.RoomTile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private final int id;
    private String username;
    private int credits;
    private int pixels;
    private int diamonds;
    private final ArrayList<Item> inventory = new ArrayList<Item>();
    private Room room;
    private int x;
    private int y;
    private int z;
    private String sso;

    public User(ResultSet set) throws SQLException {
        // TODO: create a load function
        this.id = set.getInt("id");
        this.username = set.getString("username");
        this.credits = set.getInt("credits");
        this.pixels = set.getInt("pixels");
        this.diamonds = set.getInt("diamonds");
        this.setInventory();
    }

    public void setInventory() {
        for(Item item: ItemManager.getItems().values()) {
            if(item.getOwner() == this.id) {
                this.inventory.add(item);
            }
        }
    }

    public void giveGift(User user, Item furni) {
        this.deleteItemFromInventory(furni);
        user.addItemToInventory(furni);
    }

    public void addItemToInventory(Item furni) {
        this.inventory.add(furni);
    }

    public void deleteItemFromInventory(Item item) {

    }

    public boolean checkSso() {
        return false;
    }

    public String getSso() {
        return this.sso;
    }

    public ArrayList<Item> getInventory() {
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
