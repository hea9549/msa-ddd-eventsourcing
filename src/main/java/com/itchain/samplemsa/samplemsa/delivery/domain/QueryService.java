package com.itchain.samplemsa.samplemsa.delivery.domain;

import com.itchain.samplemsa.samplemsa.delivery.domain.dto.DeliveryDTO;

import java.util.List;

public interface QueryService {
    DeliveryDTO getDeliverInfo(String id);
    List<DeliveryDTO> getDeliverInfos();
}
