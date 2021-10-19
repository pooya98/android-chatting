package com.example.android_chatting.DTO;

import java.io.Serializable;

public class ChatData implements Serializable {
    private String message;
    private String nickname;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
