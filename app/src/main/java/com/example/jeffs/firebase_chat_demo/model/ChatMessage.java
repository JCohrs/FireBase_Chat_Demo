package com.example.jeffs.firebase_chat_demo.model;

/**
 * Created by jeffs on 4/3/2017.
 */

public class ChatMessage {
    private String msg;
    private String username;

    public ChatMessage(String msg, String username) {
        this.msg = msg;
        this.username = username;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // private String videoURL;
    // private boolean msgRead;
}
