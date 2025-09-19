package com.vivekt.kt.serice;

import com.vivekt.ktpp.datamodel.Order;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.*;

@Service
public class KafkaDataProviderService {


    public List<Order> getOrders() {
        List<Order> result = new ArrayList<>();

        String ORDER_TOPIC = "kt-orders.02";
        String bootstrapServers = "localhost:9092";
        String groupId = "my-consumer-group";

        // Consumer configuration
        Properties props = new Properties();
        props.put(ConsumerConfig

                .BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(org.springframework.kafka.support.serializer.JsonDeserializer.TRUSTED_PACKAGES, "com.vivekt.ktpp.datamodel");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                "org.springframework.kafka.support.serializer.JsonDeserializer");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        // "earliest" = consume from beginning if no offset found

        KafkaConsumer<String, Order> consumer = new KafkaConsumer<>(props);

        // Subscribe to the topic
        consumer.subscribe(Collections.singletonList(ORDER_TOPIC));

        System.out.println("Consumer started. Waiting for messages...");

        try {
            while (true) {
                // poll for new records
                ConsumerRecords<String, Order> records =
                        consumer.poll(Duration.ofMillis(2000));

                for (ConsumerRecord<String, Order> record : records) {
                    System.out.printf("Consumed record(key=%s value=%s) " +
                                    "meta(partition=%d, offset=%d)%n",
                            record.key(), record.value(),
                            record.partition(), record.offset());
                    result.add(record.value());
                }
                if (result.size() > 0) {
                    System.out.println("*********** returning poll results");
                    return result;
                }
            }
        } finally {
            consumer.close();
        }
    }
}



