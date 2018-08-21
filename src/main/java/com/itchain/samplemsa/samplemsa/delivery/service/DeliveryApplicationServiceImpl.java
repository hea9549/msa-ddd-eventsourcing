package com.itchain.samplemsa.samplemsa.delivery.service;

import com.itchain.samplemsa.samplemsa.common.Event;
import com.itchain.samplemsa.samplemsa.common.EventRepository;
import com.itchain.samplemsa.samplemsa.common.Util;
import com.itchain.samplemsa.samplemsa.delivery.domain.Delivery;
import com.itchain.samplemsa.samplemsa.delivery.domain.DeliverStatus;
import com.itchain.samplemsa.samplemsa.delivery.domain.dto.TradeInfoDTO;
import com.itchain.samplemsa.samplemsa.delivery.domain.event.DeliveryInfoChangedEvent;
import com.itchain.samplemsa.samplemsa.delivery.domain.event.DeliveryInfoCreatedEvent;

import java.util.List;

public class DeliveryApplicationServiceImpl implements DeliveryApplicationService {
    // todo DI
    EventRepository eventRepository;

    @Override
    public Delivery newDeliveryServiceWithTradeInfo(TradeInfoDTO tradeInfoDTO) {
        Delivery delivery = new Delivery();
        delivery.changeStatus(DeliverStatus.DONE);
        List<Event> events = eventRepository.load("34");
        Delivery asdf = new Delivery(events);
        return delivery;
    }

    @Override
    public Delivery changeDeliveryStatus(String id, DeliverStatus status) {

        Delivery delivery = (Delivery)eventRepository.load(id);
        return delivery;
    }
}
