package com.java.websocketts.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.config.AbstractMessageBrokerConfiguration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
// enabled a broker backed messaging over web socket using Stomp
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // in-memory message broker to carry the messages back to the client on destinations prefixed with “/topic”.
    @Override
    public void configureMessageBroker(final MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    //registerStompEndpoints method registers the “/chat” endpoint, enabling Spring’s STOMP support.
    @Override
    public void registerStompEndpoints(final StompEndpointRegistry registry) {
        registry.addEndpoint("/chat");
        registry.addEndpoint("/chat").withSockJS();
//        registry.addEndpoint("/chatwithbots");
//        registry.addEndpoint("/chatwithbots").withSockJS();
    }

}
