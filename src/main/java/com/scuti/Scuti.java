package com.scuti;

import com.scuti.catalog.CatalogManager;
import com.scuti.items.ItemManager;
import com.scuti.messages.incoming.IncomingEventManager;
import com.scuti.rooms.RoomManager;
import com.scuti.users.UserManager;

public class Scuti {
    private final UserManager userManager;
    private final RoomManager roomManager;
    private final ItemManager itemManager;
    private final CatalogManager catalogManager;
    private final IncomingEventManager incomingEventManager;

    public Scuti() {
        this.userManager = new UserManager();
        this.roomManager = new RoomManager();
        this.itemManager = new ItemManager();
        this.catalogManager = new CatalogManager();
        this.incomingEventManager = new IncomingEventManager();
    }

    public void preload() {

    }

    public IncomingEventManager getIncomingEventManager() {
        return this.incomingEventManager;
    }

    public CatalogManager getCatalogManager() {
        return this.catalogManager;
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
