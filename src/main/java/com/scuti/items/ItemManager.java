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
}
