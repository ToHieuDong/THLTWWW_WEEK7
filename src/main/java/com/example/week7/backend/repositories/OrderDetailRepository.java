package com.example.week7.backend.repositories;

import com.example.week7.backend.models.OrderDetail;
import com.example.week7.backend.pks.OrderDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPK> {
}
