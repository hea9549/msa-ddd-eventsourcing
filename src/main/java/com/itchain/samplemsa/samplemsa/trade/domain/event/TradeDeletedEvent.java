package com.itchain.samplemsa.samplemsa.trade.domain.event;

import com.itchain.samplemsa.samplemsa.common.Event;
import com.itchain.samplemsa.samplemsa.trade.domain.TradeStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TradeDeletedEvent implements Event {
    private String id;

    @Override
    public String getID() {
        return id;
    }
}
