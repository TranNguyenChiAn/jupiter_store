package com.jupiter.store.web.rest;

import com.jupiter.store.domain.Cart;
import com.jupiter.store.domain.CartItem;
import com.jupiter.store.dto.AddToCartDTO;
import com.jupiter.store.service.CartItemService;
import com.jupiter.store.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartResource {
    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/create-cart")
    public ResponseEntity<Cart> createCart(Long customerId) {
        Cart cart = cartService.createCart(customerId);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/add-cart-items")
    public ResponseEntity<CartItem> addProductToCart(Long cartId, @RequestBody AddToCartDTO addToCartDTO) {
        CartItem cartItem = cartItemService.addProductToCart(cartId, addToCartDTO);
        return ResponseEntity.ok(cartItem);
    }
}
