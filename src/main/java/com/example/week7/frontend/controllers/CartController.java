package com.example.week7.frontend.controllers;

import com.example.week7.backend.models.CartItem;
import com.example.week7.backend.models.Product;
import com.example.week7.backend.repositories.ProductImageRepository;
import com.example.week7.backend.repositories.ProductRepository;
import com.example.week7.backend.servives.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cart") // Lưu giỏ hàng trong session
public class CartController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductImageRepository productImageRepository;
    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public String loadHome(@ModelAttribute("cart") List<CartItem> cart, Model model) {
        Map<Product, String> productStringMap = productService.getProducts();
        model.addAttribute("productStringMap", productStringMap);
        int sl=cart.isEmpty()?0:cart.size();
        model.addAttribute("slCart", sl);

        return "client/Home";
    }

    @ModelAttribute("cart")
    public List<CartItem> getCart() {
        return new ArrayList<>();
    }

//    @GetMapping("/product/{productId}") //xem chi tiết mặt hàng
//    public String viewProductDetails(@PathVariable Long productId, Model model) {
//        Product product = productRepository.findById(productId).orElse(null);
//        model.addAttribute("product", product);
//        return "productDetails";
//    }

    @GetMapping("/addToCart/{productId}")
    public String addToCart(@PathVariable Long productId,
                            @ModelAttribute("cart") List<CartItem> cart) {

        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            return "redirect:/cart/home";
        } else  {
            for (CartItem item: cart) {
                if (item.getProduct().getProduct_id()==productId) {
                    item.setQuantity(item.getQuantity()+1);
                    return "redirect:/cart/home";
                }
            }
            cart.add(new CartItem(product, 1));
        }


//        if (product != null && quantity > 0) {
//            CartItem cartItem = new CartItem();
//            cartItem.setProduct(product);
//            cartItem.setQuantity(quantity);
//            cart.put(productId, cartItem);
//        }

        return "redirect:/cart/home";
    }

    @GetMapping("/cart")
    public String viewCart(@ModelAttribute("cart") List<CartItem> cart, Model model) {
        model.addAttribute("cartItems", cart);
        return "client/cart";
    }

    @GetMapping("/checkout")
    public String checkOutCart( @ModelAttribute("cart") List<CartItem> cart) {
        cart.clear();
        return "redirect:/cart/home";
    }
}
