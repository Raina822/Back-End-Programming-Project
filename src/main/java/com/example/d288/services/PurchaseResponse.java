package com.example.d288.services;

import com.example.d288.entities.StatusType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PurchaseResponse {

    private String orderTackingNumber;
    private StatusType status;

    public PurchaseResponse(String orderTackingNumber){

        this.orderTackingNumber = orderTackingNumber;
    }
}
