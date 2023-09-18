package com.developer.colorblast.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Activez un message broker pour gérer les messages WebSocket
        config.enableSimpleBroker("/topic");
        // Configurez l'end-point WebSocket pour se connecter depuis le navigateur
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Définissez l'end-point WebSocket accessible via HTTP
        registry.addEndpoint("/websocket-endpoint").withSockJS();
    }
}

