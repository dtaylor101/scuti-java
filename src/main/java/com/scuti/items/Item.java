package com.scuti.items;

import java.sql.ResultSet;

public class Item {
    private int id;
    private String name;

    public Item(ResultSet set) {
        // ...
    }

    public int getId() {
        return this.id;
    }
}
