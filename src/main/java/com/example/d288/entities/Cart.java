package com.example.d288.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "carts")
@Getter
@Setter
public class Cart {

    private Long id;

    private BigDecimal package_price;


}
