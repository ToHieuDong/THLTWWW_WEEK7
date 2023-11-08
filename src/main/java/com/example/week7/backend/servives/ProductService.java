package com.example.week7.backend.servives;

import com.example.week7.backend.models.Product;
import com.example.week7.backend.models.ProductImage;
import com.example.week7.backend.repositories.ProductImageRepository;
import com.example.week7.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService  {

    private ProductRepository productRepository;
    private ProductImageRepository productImageRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductImageRepository productImageRepository) {
        this.productRepository = productRepository;
        this.productImageRepository = productImageRepository;
    }

    public Map<Product, String> getProducts () {

        List<Product> products = productRepository.findAll();
        Map<Product, String> productStringMap = new HashMap<>();
        for (Product product : products) {
            if (!product.getProductImageList().isEmpty()) {
                productStringMap.put(product, product.getProductImageList().get(0).getPath());
            }
        }
        return productStringMap;
    }
}
