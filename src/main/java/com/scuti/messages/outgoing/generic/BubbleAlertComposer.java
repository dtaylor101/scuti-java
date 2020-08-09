package com.scuti.messages.outgoing.generic;

import com.scuti.messages.MessageComposer;

import java.util.HashMap;

public class BubbleAlertComposer extends MessageComposer {
    private final HashMap<String, String> data;

    public BubbleAlertComposer(String img, String title, String content) {
        this.data = new HashMap<String, String>();
        this.data.put("img", img);
        this.data.put("title", title);
        this.data.put("content", content);
    }

    public HashMap<String, String> getData() {
        return this.data;
    }

}
