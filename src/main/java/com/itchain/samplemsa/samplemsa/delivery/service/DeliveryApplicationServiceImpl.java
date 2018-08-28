//package com.itchain.samplemsa.samplemsa.delivery.application;
//
//import com.itchain.samplemsa.samplemsa.common.AggregateRepository;
//import com.itchain.samplemsa.samplemsa.common.Event;
//import com.itchain.samplemsa.samplemsa.common.EventRepository;
//import com.itchain.samplemsa.samplemsa.common.Util;
//import com.itchain.samplemsa.samplemsa.delivery.DeliveryRepository;
//import com.itchain.samplemsa.samplemsa.delivery.domain.Delivery;
//import com.itchain.samplemsa.samplemsa.delivery.domain.OrderStatus;
//import com.itchain.samplemsa.samplemsa.delivery.domain.dto.TradeInfoDTO;
//import com.itchain.samplemsa.samplemsa.delivery.domain.event.DeliveryInfoChangedEvent;
//import com.itchain.samplemsa.samplemsa.delivery.domain.event.DeliveryInfoCreatedEvent;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//public class DeliveryApplicationServiceImpl implements DeliveryApplicationService {
//
//    @Autowired
//    DeliveryRepository deliveryRepository;
//
//    @Override
//    public Delivery newDeliveryServiceWithTradeInfo(TradeInfoDTO tradeInfoDTO) {
//        Delivery delivery = new Delivery();
//        delivery.changeStatus(OrderStatus.DONE);
//        deliveryRepository.save(delivery);
//        Delivery asdf = new Delivery(events);
//        return delivery;
//    }
//
//    @Override
//    public Delivery changeDeliveryStatus(String id, OrderStatus status) {
//
//        Delivery delivery = (Delivery)eventRepository.load(id);
//        return delivery;
//    }
//}
