package com.scuti;

import com.scuti.items.ItemManager;
import com.scuti.rooms.RoomManager;
import com.scuti.users.UserManager;

public class Scuti {
    private final UserManager userManager;
    private final RoomManager roomManager;
    private final ItemManager itemManager;

    public Scuti() {
        this.userManager = new UserManager();
        this.roomManager = new RoomManager();
        this.itemManager = new ItemManager();
    }

    public void preload() {

    }

    public ItemManager getItemManager() {
        return this.itemManager;
    }

    public UserManager getUserManager() {
        return this.userManager;
    }

    public RoomManager getRoomManager() {
        return this.roomManager;
    }

    public int getOnlinePlayers() {
        return this.userManager.getOnlineUsers().size();
    }

    public void shutdown() {

    }
}
