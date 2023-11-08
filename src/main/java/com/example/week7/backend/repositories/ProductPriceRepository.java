package com.example.week7.backend.repositories;

import com.example.week7.backend.models.ProductPrice;
import com.example.week7.backend.pks.ProductPricePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, ProductPricePK> {
}
