package com.itchain.samplemsa.samplemsa.common;

import com.itchain.samplemsa.samplemsa.delivery.DeliveryRepository;
import com.itchain.samplemsa.samplemsa.delivery.domain.DeliverStatus;
import com.itchain.samplemsa.samplemsa.delivery.domain.Delivery;
import org.junit.Test;

public class AggregateTest {
    DeliveryRepository deliveryRepository = new DeliveryRepository(new EventRepositoryImpl());

    @Test
    public void TestOnEvent() {
        SampleAggregate aggregate = new SampleAggregate();
        aggregate.startSecondEvent();
    }

    @Test
    public void repoTest() {
        Delivery delivery = new Delivery("1","1","today","startDate");
        delivery.changeStatus(DeliverStatus.DONE);
        deliveryRepository.save(delivery);

        Delivery loadDelivery = deliveryRepository.findById("1");
        System.out.println(loadDelivery.getDeliverStatus());
    }

}
