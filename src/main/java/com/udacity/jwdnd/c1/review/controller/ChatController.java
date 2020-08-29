package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.service.MessageService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chat")
public class ChatController {

    MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String getChatPage(ChatForm chatForm, Model model) {
        model.addAttribute("messages", this.messageService.getChatMessages());
        return "chat";
    }

    @PostMapping
    public String postChatPage(ChatForm chatForm, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        chatForm.setUsername(auth.getName());

        this.messageService.addMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("messages", messageService.getChatMessages());
        return "chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes() {
        return new String[] {"Say", "Shout", "Whisper"};
    }
}
