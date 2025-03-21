package com.jupiter.store.web.rest;

import com.jupiter.store.dto.CartDTO;
import com.jupiter.store.model.Cart;
import com.jupiter.store.model.CartItem;
import com.jupiter.store.dto.AddToCartDTO;
import com.jupiter.store.service.CartItemService;
import com.jupiter.store.service.CartService;
import com.jupiter.store.utils.SecurityUtils;
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

    @GetMapping("/get-cart")
    public ResponseEntity<CartDTO> getCart(Long userId) {
        return ResponseEntity.ok(cartService.getCart(userId));
    }

    @PostMapping("/create-cart")
    public ResponseEntity<Cart> createCart(Long userId) {
        Cart cart = cartService.createCart(userId);
        return ResponseEntity.ok(cart);
    }
    @PostMapping("/add-cart-items/{cartId}")
    public ResponseEntity<CartItem> addProductToCart(@RequestParam Long cartId, @RequestBody AddToCartDTO addToCartDTO) {
        CartItem cartItem = cartItemService.addProductToCart(cartId, addToCartDTO);
        return ResponseEntity.ok(cartItem);
    }
    @PutMapping("/update-cart-item/{cartItemId}")
    public ResponseEntity<CartItem> updateCartItem(@RequestParam Long cartItemId, @RequestParam int quantity) {
        CartItem updatedCartItem = cartItemService.updateCartItem(cartItemId, quantity);
        return ResponseEntity.ok(updatedCartItem);
    }
    @DeleteMapping("/delete-cart-item/{cartId}")
    public void deleteCartItem(@RequestParam Long cartId) {
        cartItemService.deleteCartItem(cartId);
    }
}