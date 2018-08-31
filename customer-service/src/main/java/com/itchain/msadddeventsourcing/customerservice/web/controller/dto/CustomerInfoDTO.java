package com.itchain.msadddeventsourcing.customerservice.web.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CustomerInfoDTO {
    private String id;
    private String pw;
    private String name;
    private String address;
    private String registeredDay;
}