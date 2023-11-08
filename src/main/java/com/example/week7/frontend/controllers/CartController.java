package com.example.week7.frontend.controllers;

import com.example.week7.backend.models.CartItem;
import com.example.week7.backend.models.Product;
import com.example.week7.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cart") // Lưu giỏ hàng trong session
public class CartController {
    @Autowired
    private ProductRepository productRepository;

    @ModelAttribute("cart")
    public Map<Long, CartItem> getCart() {
        return new HashMap<>();
    }

//    @GetMapping("/product/{productId}") //xem chi tiết mặt hàng
//    public String viewProductDetails(@PathVariable Long productId, Model model) {
//        Product product = productRepository.findById(productId).orElse(null);
//        model.addAttribute("product", product);
//        return "productDetails";
//    }

    @PostMapping("/addToCart/{productId}")
    public String addToCart(@PathVariable Long productId, @RequestParam("quantity") int quantity,
                            @ModelAttribute("cart") Map<Long, CartItem> cart) {
        Product product = productRepository.findById(productId).orElse(null);

        if (product != null && quantity > 0) {
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cart.put(productId, cartItem);
        }

        return "redirect:/cart/cart";
    }

    @GetMapping("/cart")
    public String viewCart(@ModelAttribute("cart") Map<Long, CartItem> cart, Model model) {
        model.addAttribute("cartItems", cart.values());
        return "client/cart";
    }
}
