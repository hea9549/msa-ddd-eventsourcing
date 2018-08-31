package com.itchain.msadddeventsourcing.customerservice.port.adapter.service;


import com.itchain.msadddeventsourcing.customerservice.web.controller.dto.OrderInfoDTO;

import java.util.List;

public interface OrderAdapter {
    List<OrderInfoDTO> getTradeListByCustomerID(String id);
}
