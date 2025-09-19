package com.vivekt.kt.controller;



import com.vivekt.kt.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/send") // listens to /app/send
    @SendTo("/topic/messages") // sends to /topic/messages
    public Message sendMessage(Message message) throws Exception {
        // Simulate processing delay
        Thread.sleep(50);
        return message;
    }
}
