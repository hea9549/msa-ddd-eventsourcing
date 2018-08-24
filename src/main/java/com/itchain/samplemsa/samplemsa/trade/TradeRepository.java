package com.itchain.samplemsa.samplemsa.trade;

import com.itchain.samplemsa.samplemsa.common.AggregateRepository;
import com.itchain.samplemsa.samplemsa.common.EventRepository;
import com.itchain.samplemsa.samplemsa.trade.domain.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TradeRepository extends AggregateRepository<Trade> {

    @Autowired
    public TradeRepository(EventRepository eventRepository) {
        super(eventRepository);
    }
}
