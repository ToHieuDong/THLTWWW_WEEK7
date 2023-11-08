package com.example.week7.frontend.controllers;

import com.example.week7.backend.models.Product;
import com.example.week7.backend.models.ProductImage;
import com.example.week7.backend.repositories.ProductImageRepository;
import com.example.week7.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/productAdd")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductImageRepository productImageRepository;

    @PostMapping("/addProd")
    public void addProd(@RequestBody List<Product> productList) {
        productRepository.saveAll(productList);
    }

    @PostMapping("/addProdImg")
    public void addProdImg(@RequestBody List<ProductImage> productImages) {
        productImageRepository.saveAll(productImages);
    }
}
