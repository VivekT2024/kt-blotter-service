package com.vivekt.kt.serice;


import com.vivekt.ktpp.datamodel.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Random;

@Service
public class OrderPushService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    KafkaDataProviderService kafkaDataProviderService;

    private final Random random = new Random();

    // Push a message every 5 seconds
    @Scheduled(fixedRate = 3000)
    public void pushMessage() {
        //Order order = Order.builder().orderId("Ord-" + random.nextInt(1000)).symbol("Google").Side("buy").Quantity(random.nextInt(100)).build();
        List<Order> orders = kafkaDataProviderService.getOrders();

        for(Order o : orders){
            messagingTemplate.convertAndSend("/topic/messages", o);
        }

    }
}
