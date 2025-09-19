package com.vivekt.kt.serice;


import com.vivekt.kt.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Random;

@Service
public class MessagePushService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    private final Random random = new Random();

    // Push a message every 5 seconds
    @Scheduled(fixedRate = 500)
    public void pushMessage() {
        Message message = new Message(
                "Server",
                "Random number: " + random.nextInt(100) + " at " + LocalTime.now()
        );
        messagingTemplate.convertAndSend("/topic/messages", message);
    }
}
