package com.developer.colorblast.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/publicChatRoom")
    public String sendMessage(String message) {
        // Votre logique de traitement ici
        if ("ping".equals(message)) {
            // Si le message est "ping", répondez avec "pong"
            return "pong";
        }
        // Autrement, traitez le message comme d'habitude
        return message;
    }
}

