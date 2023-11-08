package com.example.week7.backend.pks;

import com.example.week7.backend.models.Order;
import com.example.week7.backend.models.Product;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;

@Setter @Getter
public class OrderDetailPK implements Serializable {
    private Order order;
    private Product product;
}
