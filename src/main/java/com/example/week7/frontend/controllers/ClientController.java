package com.example.week7.frontend.controllers;

import com.example.week7.backend.models.Product;
import com.example.week7.backend.models.ProductImage;
import com.example.week7.backend.repositories.ProductImageRepository;
import com.example.week7.backend.repositories.ProductRepository;
import com.example.week7.backend.servives.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductImageRepository productImageRepository;
    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public String loadHome(Model model) {
        System.out.println("ngungu");
        Map<Product, String> productStringMap = productService.getProducts();
        model.addAttribute("productStringMap", productStringMap);

        return "client/Home";
    }

}
