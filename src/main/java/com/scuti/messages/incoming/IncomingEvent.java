package com.scuti.messages.incoming;

import org.json.JSONObject;

public abstract class IncomingEvent {
    public JSONObject data;
    public abstract void handle();
}
