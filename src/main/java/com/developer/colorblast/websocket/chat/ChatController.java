package com.developer.colorblast.websocket.chat;

import com.developer.colorblast.line.entity.LineEntity;
import com.developer.colorblast.line.service.LineService;
import com.developer.colorblast.messagerie.entity.MessagerieEntity;
import com.developer.colorblast.messagerie.service.MessagerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    private final LineService lineService;
    private final MessagerieService messagerieService;

    public ChatController(LineService lineService, MessagerieService messagerieService) {
        this.lineService = lineService;
        this.messagerieService = messagerieService;
    }

    @MessageMapping("/chat/sendMessage/{roomId}")
    public void sendMessage(@Payload LineEntity line, @DestinationVariable Long roomId) {
        LineEntity createdLine = lineService.saveLine(line);
        Optional<MessagerieEntity> messagerieEntity = messagerieService.findById(line.getIdMessagerie());
        messagerieEntity.get().setLastMessage(line.getContent());
        messagerieEntity.get().setDLastMessage(line.getDate());
        messagerieService.updateMessagerie(messagerieEntity.get());

        messagingTemplate.convertAndSend("/topic/chatroom/" + roomId, createdLine);
    }

    /*@MessageMapping("/chat/sendMessage")
    @SendTo("/topic/public")
    public LineEntity sendMessageTest(@Payload LineEntity line) {
        //System.out.println(chatMessage.getContent());
        line.setContent("AZERTYUI");
        return line;
    }*/

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(
            @Payload ChatMessage chatMessage
    ) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(
            @Payload ChatMessage chatMessage,
            SimpMessageHeaderAccessor headerAccessor
    ) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}
