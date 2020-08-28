package com.udacity.jwdnd.c1.review.model;

public class ChatForm {

    private String username;
    private String messageText;
    private String messageType;

    public ChatForm(String username, String messageText, String messageType) {
        this.username = username;
        this.messageText = messageText;
        this.messageType = messageType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
