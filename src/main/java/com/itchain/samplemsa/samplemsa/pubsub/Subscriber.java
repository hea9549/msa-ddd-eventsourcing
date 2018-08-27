package com.itchain.samplemsa.samplemsa.pubsub;

import com.itchain.samplemsa.samplemsa.common.Event;
import com.itchain.samplemsa.samplemsa.pubsub.sample.SampleEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Getter
@NoArgsConstructor
public class Subscriber {
    static final Logger logger = LoggerFactory.getLogger(Subscriber.class);

    @RabbitListener(queues = RabbitConfig.QUEUE_ORDERS)
    public void subscribe(SampleEvent event) {
        logger.info("Subscribed : " + event.toString());
    }
}
