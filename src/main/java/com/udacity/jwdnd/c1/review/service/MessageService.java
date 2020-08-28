package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import com.udacity.jwdnd.c1.review.mapper.MessageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private List<ChatMessage> chatMessages;
    private MessageMapper messageMapper;

    public MessageService() {

    }

    @PostConstruct
    public void postContruct() {
        this.chatMessages = new ArrayList<>();
    }

    public void addMessage(ChatForm chatForm) {
        switch (chatForm.getMessageType()) {
            case "Say":
                System.out.println(chatForm.getMessageText());
                System.out.println(chatForm.getUsername());
                messageMapper.insertMessage(chatForm.getUsername(), chatForm.getMessageText());
                break;
            case "Shout":
                messageMapper.insertMessage(chatForm.getUsername(), chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                messageMapper.insertMessage(chatForm.getUsername(), chatForm.getMessageText().toLowerCase());
                break;
        }
        this.chatMessages.add(messageMapper.getMessage(chatForm.getUsername()));
    }

    public List<ChatMessage> getChatMessages() {
        return new ArrayList<>(this.chatMessages);
    }

}
