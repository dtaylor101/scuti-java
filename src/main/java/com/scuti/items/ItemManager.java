package com.scuti.items;

import com.scuti.users.User;

import java.util.HashMap;

public class ItemManager {

    private static final HashMap<Integer, Item> items = new HashMap<Integer, Item>();

    public static void load() {

    }

    public static HashMap<Integer, Item> getItems() {
        return items;
    }

    public static HashMap<Integer, Item> createInventory(User user) {
        HashMap<Integer, Item> inventory = new HashMap<Integer, Item>();
        int n = 0;
        for(Item item: items.values()) {
            if(item.getOwner() == user.getId()) {
                n = n + 1;
                inventory.put(n, item);
            }
        }

        return inventory;
    }
}
