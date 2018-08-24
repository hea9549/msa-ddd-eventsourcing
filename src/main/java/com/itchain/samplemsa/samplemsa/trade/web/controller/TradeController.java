package com.itchain.samplemsa.samplemsa.trade.web.controller;


import com.itchain.samplemsa.samplemsa.trade.application.TradeApplicationService;
import com.itchain.samplemsa.samplemsa.trade.application.TradeApplicationServiceImpl;
import com.itchain.samplemsa.samplemsa.trade.domain.Trade;
import com.itchain.samplemsa.samplemsa.trade.domain.command.CreateTradeCommand;
import com.itchain.samplemsa.samplemsa.trade.domain.dto.ProductInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TradeController {

    @Autowired
    TradeApplicationServiceImpl tradeApplicationService;

    @RequestMapping(value = "/trades/{id}", method = RequestMethod.GET)
    public Trade getTradeById(@PathVariable String id) {
        return tradeApplicationService.getTradeById(id);
    }



    @RequestMapping(value = "/trades", method = RequestMethod.POST)
    public void createTrade(@RequestBody CreateTradeCommand createTradeCommand) {
        tradeApplicationService.addTrade(createTradeCommand.getProductId(), createTradeCommand.getBuyerId(), createTradeCommand.getSignedDate(), createTradeCommand.getPrice(), createTradeCommand.getQuantity());
    }

    @RequestMapping(value = "/trades/{id}", method = RequestMethod.DELETE)
    public void cancelTrade(@RequestBody String id) {
        tradeApplicationService.cancelTrade(id);
    }


}
