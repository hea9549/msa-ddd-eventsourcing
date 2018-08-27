package com.itchain.samplemsa.samplemsa.trade.web.controller;


import com.itchain.samplemsa.samplemsa.trade.application.TradeApplicationService;
import com.itchain.samplemsa.samplemsa.trade.application.TradeApplicationServiceImpl;
import com.itchain.samplemsa.samplemsa.trade.domain.Trade;
import com.itchain.samplemsa.samplemsa.trade.domain.command.CreateTradeCommand;
import com.itchain.samplemsa.samplemsa.trade.domain.dto.ProductInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class TradeController {

    @Autowired
    TradeApplicationServiceImpl tradeApplicationService;

    @RequestMapping(value = "/trades/{id}", method = RequestMethod.GET)
    public Trade getTradeById(@PathVariable String id) {
        return tradeApplicationService.getTradeById(id);
    }



    @RequestMapping(value = "/trades", method = RequestMethod.POST)
    public Trade createTrade(@RequestBody CreateTradeCommand createTradeCommand) {
        Trade trade = tradeApplicationService.addTrade(createTradeCommand.getProductId(), createTradeCommand.getBuyerId(), createTradeCommand.getSignedDate(), createTradeCommand.getPrice(), createTradeCommand.getQuantity());
        if (trade == null) {
            return null;
        }

        return trade;
    }

    @RequestMapping(value = "/trades/{id}", method = RequestMethod.DELETE)
    public Trade cancelTrade(@PathVariable String id) {
        Trade trade = tradeApplicationService.cancelTrade(id);
        return trade;
    }


}
