package com.scuti.messages.incoming.user;

import com.scuti.messages.incoming.IncomingEvent;

public class TestEvent extends IncomingEvent {
    @Override
    public void handle() {
        System.out.println(this.data.get("message"));
    }
}
