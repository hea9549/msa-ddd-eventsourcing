package com.itchain.samplemsa.samplemsa.delivery.web.controller;

import com.itchain.samplemsa.samplemsa.delivery.domain.DeliverStatus;
import com.itchain.samplemsa.samplemsa.delivery.domain.Delivery;
import com.itchain.samplemsa.samplemsa.delivery.domain.DeliveryService;
import com.itchain.samplemsa.samplemsa.delivery.domain.dto.DeliveryDTO;
import com.itchain.samplemsa.samplemsa.delivery.domain.dto.TradeInfoDTO;
import com.itchain.samplemsa.samplemsa.delivery.application.DeliveryApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeliveryController {
    // todo DI
    @Autowired
    DeliveryService deliveryService;
    @Autowired
    DeliveryApplicationService deliveryApplicationService;

    @RequestMapping(value = "/deliveries", method = RequestMethod.POST)
    public DeliveryDTO newDeliveryInfo(@RequestBody TradeInfoDTO tradeInfoDTO) {
        Delivery delivery = deliveryService.newDeliveryFromTrade(tradeInfoDTO);
        return new DeliveryDTO(delivery.getID(), delivery.getProductId(), delivery.getBuyerId()
                , delivery.getBuyDate(), delivery.getStartDate(), delivery.getDeliverStatus());
    }

    // todo need self projection or delete this func
    @RequestMapping(value = "/deliveries", method = RequestMethod.GET)
    public List<DeliveryDTO> getDeliveryInfos() {
        return null;
    }

    @RequestMapping(value = "/deliveries/{deliveryId}", method = RequestMethod.GET)
    public DeliveryDTO getDeliveryInfo(@PathVariable String deliveryId) {
        Delivery delivery = deliveryService.getDeliveryByID(deliveryId);
        return deliveryService.changeToDTO(delivery);
    }

    @RequestMapping(value = "/deliveries/{deliveryId}", method = RequestMethod.PUT)
    public DeliveryDTO changeDeliveryStatus(@PathVariable String deliveryId, @RequestParam DeliverStatus status) {
        Delivery delivery = deliveryApplicationService.changeDeliveryStatus(deliveryId,status);
        return new DeliveryDTO(delivery.getID(), delivery.getProductId(), delivery.getBuyerId()
                , delivery.getBuyDate(), delivery.getStartDate(), delivery.getDeliverStatus());
    }
}
