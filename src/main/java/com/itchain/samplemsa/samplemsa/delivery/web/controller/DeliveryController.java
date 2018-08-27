package com.itchain.samplemsa.samplemsa.delivery.web.controller;

import com.itchain.samplemsa.samplemsa.delivery.domain.Delivery;
import com.itchain.samplemsa.samplemsa.delivery.domain.DeliveryService;
import com.itchain.samplemsa.samplemsa.delivery.domain.dto.DeliveryDTO;
import com.itchain.samplemsa.samplemsa.delivery.domain.dto.TradeInfoDTO;
import com.itchain.samplemsa.samplemsa.delivery.application.DeliveryApplicationService;
import com.itchain.samplemsa.samplemsa.delivery.port.adapter.HttpDeliveryAdapter;
import com.itchain.samplemsa.samplemsa.delivery.port.adapter.HttpTradeAdapter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeliveryController {
    // todo DI
    DeliveryApplicationService deliveryApplicationService;
    DeliveryService deliveryService;
    HttpTradeAdapter tradeAdapter;
    HttpDeliveryAdapter deliveryAdapter;

    @RequestMapping(value = "/deliveries",method = RequestMethod.POST)
    public DeliveryDTO newDeliveryInfo(@RequestParam String buyerId, @RequestParam String productId,
                                       @RequestParam String buyDate){
        TradeInfoDTO tradeInfoDTO = new TradeInfoDTO(productId,buyerId,buyDate);
        Delivery delivery = deliveryService.deliveryFromTrade(tradeInfoDTO);
        return new DeliveryDTO(delivery.getID(), delivery.getProductId(), delivery.getBuyerId()
                                , delivery.getBuyDate(), delivery.getStartDate(), delivery.getDeliverStatus());
    }

    @RequestMapping(value = "/deliveries",method = RequestMethod.GET)
    public List<DeliveryDTO> getDeliveryInfos(){
        return queryService.getDeliverInfos();
    }

    @RequestMapping(value = "/deliveries/{deliveryId}",method = RequestMethod.GET)
    public DeliveryDTO getDeliveryInfo(@PathVariable String deliveryId){
        return queryService.getDeliverInfo(deliveryId);
    }

    @RequestMapping(value = "/deliveries/{deliveryId}",method = RequestMethod.PUT)
    public DeliveryDTO changeDeliveryStatus(@PathVariable String deliveryId, @RequestParam TradeStatus status){
        Delivery delivery = deliveryApplicationService.changeDeliveryStatus(deliveryId,status);
        return new DeliveryDTO(delivery.GetID(), delivery.getProductId(), delivery.getBuyerId()
                , delivery.getBuyDate(), delivery.getStartDate(), delivery.getDeliverStatus());
    }
}
