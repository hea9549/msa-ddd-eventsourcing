package com.itchain.samplemsa.samplemsa.pubsub.sample;

import com.itchain.samplemsa.samplemsa.common.Event;
import com.itchain.samplemsa.samplemsa.pubsub.Publisher;
import com.itchain.samplemsa.samplemsa.pubsub.RabbitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SampleController {
    @Autowired
    private Publisher<SampleEvent> publisher;

    @PostMapping("/sample/event")
    public void handleMessage(@RequestBody SampleEvent event) {
        System.out.println("Controller event: " + event);
        publisher.publish(RabbitConfig.QUEUE_ORDERS, event);
    }
}
