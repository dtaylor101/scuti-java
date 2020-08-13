package com.scuti.messages.incoming;

import com.scuti.messages.incoming.user.TestEvent;
import com.scuti.messages.incoming.user.UserLoginEvent;

import java.util.HashMap;

public class IncomingEventManager {
    private final HashMap<Integer, Class<? extends IncomingEvent>> events;

    public IncomingEventManager() {
        this.events = new HashMap<>();
        this.registerUserEvent();
    }

    public HashMap<Integer, Class<? extends IncomingEvent>> getEvents() {
        return this.events;
    }

    public void registerUserEvent() {
        events.put(Incoming.UserLoginEvent, UserLoginEvent.class);
        events.put(Incoming.UserTestEvent, TestEvent.class);
    }
}
