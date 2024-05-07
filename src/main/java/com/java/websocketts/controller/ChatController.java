package com.java.websocketts.controller;

import com.java.websocketts.model.Message;
import com.java.websocketts.model.OutputMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ChatController {

    @MessageMapping("/chat") // spring's approach to working with STOMP messaging is to associate the controller method to configured endpoint.
    @SendTo("/topic/messages") // destination will be defined here..
    public OutputMessage send(final Message message) throws Exception {
        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }
}
