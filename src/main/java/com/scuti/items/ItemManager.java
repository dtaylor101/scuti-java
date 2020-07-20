package com.scuti.items;

import com.scuti.users.User;

import java.util.HashMap;

public class ItemManager {

    private final HashMap<Integer, Item> items;

    public ItemManager() {
        this.items = new HashMap<Integer, Item>();
    }

    public void loadItems() {

    }

    public HashMap<Integer, Item> getItems() {
        return this.items;
    }
}
