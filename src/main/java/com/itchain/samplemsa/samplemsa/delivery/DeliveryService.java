package com.itchain.samplemsa.samplemsa.delivery;

import com.itchain.samplemsa.samplemsa.delivery.domain.Delivery;
import com.itchain.samplemsa.samplemsa.delivery.domain.dto.TradeInfoDTO;

public class DeliveryService {
    Delivery fromTradeInfo(TradeInfoDTO tradeInfoDTO){
        return new Delivery();
    }
}
