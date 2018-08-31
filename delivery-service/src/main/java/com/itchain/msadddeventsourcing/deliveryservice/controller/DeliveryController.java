package com.itchain.msadddeventsourcing.deliveryservice.controller;

import com.itchain.msadddeventsourcing.deliveryservice.application.DeliveryQueryService;
import com.itchain.msadddeventsourcing.deliveryservice.application.DeliveryApplicationService;
import com.itchain.msadddeventsourcing.deliveryservice.domain.DeliverStatus;
import com.itchain.msadddeventsourcing.deliveryservice.domain.Delivery;
import com.itchain.msadddeventsourcing.deliveryservice.domain.dto.DeliveryDTO;
import com.itchain.msadddeventsourcing.deliveryservice.domain.dto.TradeInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeliveryController {

    @Autowired
    DeliveryQueryService deliveryQueryService;

    @Autowired
    DeliveryApplicationService deliveryApplicationService;

    @RequestMapping(value = "/deliveries/{deliveryId}/status", method = RequestMethod.PUT)
    public void changeDeliveryStatus(@PathVariable String deliveryId, @RequestParam DeliverStatus status) {
        deliveryApplicationService.changeDeliveryStatus(deliveryId,status);
    }

    @RequestMapping(value = "/deliveries/{deliveryId}", method = RequestMethod.POST)
    public Delivery newDeliveryInfo(@PathVariable String deliveryId, @RequestBody TradeInfoDTO tradeInfoDTO) {
        return deliveryApplicationService.createDelivery(deliveryId,tradeInfoDTO.getBuyerId(),tradeInfoDTO.getBuyDate());
    }

    @RequestMapping(value = "/deliveries", method = RequestMethod.GET)
    public List<Delivery> getDeliveryList() {
        return deliveryQueryService.getDeliveryList();
    }

    @RequestMapping(value = "/deliveries/{deliveryId}", method = RequestMethod.GET)
    public Delivery getDeliveryInfo(@PathVariable String deliveryId) {
        return deliveryQueryService.getDeliveryInfo(deliveryId);
    }


}
