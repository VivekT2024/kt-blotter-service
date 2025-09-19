package com.vivekt.kt.controller;



import com.vivekt.ktpp.datamodel.Order;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/send") // listens to /app/send
    @SendTo("/topic/messages") // sends to /topic/messages
    public Order sendMessage(Order order) throws Exception {
        // Simulate processing delay
        Thread.sleep(50);
        return order;
    }
}
