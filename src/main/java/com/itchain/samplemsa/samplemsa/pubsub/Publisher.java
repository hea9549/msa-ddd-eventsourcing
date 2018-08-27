package com.itchain.samplemsa.samplemsa.pubsub;

import com.itchain.samplemsa.samplemsa.common.Event;
import lombok.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@NoArgsConstructor
public class Publisher<T extends Event> {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publish(String topic, T event) {
        this.rabbitTemplate.convertAndSend(topic, event);
    }
}
