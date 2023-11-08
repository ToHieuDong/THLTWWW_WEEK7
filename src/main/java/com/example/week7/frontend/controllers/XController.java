package com.example.week7.frontend.controllers;

import com.example.week7.backend.models.Product;
import com.example.week7.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class XController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/getListProducts")
    public String getProducts(Model model) {
        List<Product> lst = productRepository.findAll();
        model.addAttribute("lstProducts",lst );
        System.out.println(lst);
        return "admin/products";
    }


}
