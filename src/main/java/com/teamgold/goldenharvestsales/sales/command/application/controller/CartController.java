package com.teamgold.goldenharvestsales.sales.command.application.controller;

import com.teamgold.goldenharvestsales.common.response.ApiResponse;
import com.teamgold.goldenharvestsales.sales.command.application.dto.AddToCartRequest;
import com.teamgold.goldenharvestsales.sales.command.application.dto.CartResponse;
import com.teamgold.goldenharvestsales.sales.command.application.dto.UpdateCartItemRequest;
import com.teamgold.goldenharvest.domain.sales.command.application.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/items")
    public ResponseEntity<ApiResponse<Void>> addItemToCart(
            @AuthenticationPrincipal Jwt jwt,
            @RequestBody AddToCartRequest request) {
        cartService.addItemToCart(jwt.getSubject(), request);
        return ResponseEntity.ok(ApiResponse.success(null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<CartResponse>> getCart(
            @AuthenticationPrincipal Jwt jwt
    ) {
        CartResponse cartResponse = cartService.getCart(jwt.getSubject());
        return ResponseEntity.ok(ApiResponse.success(cartResponse));
    }

    @PutMapping("/items")
    public ResponseEntity<ApiResponse<Void>> updateCartItemQuantity(
            @AuthenticationPrincipal Jwt jwt,
            @RequestBody UpdateCartItemRequest request) {

        cartService.updateItemQuantity(jwt.getSubject(), request);
        return ResponseEntity.ok(ApiResponse.success(null));
    }

    @DeleteMapping("/items/{skuNo}")
    public ResponseEntity<ApiResponse<Void>> removeItemFromCart(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable String skuNo) {

        cartService.removeItem(jwt.getSubject(), skuNo);
        return ResponseEntity.ok(ApiResponse.success(null));
    }

    @PostMapping("/checkout")
    public ResponseEntity<ApiResponse<String>> checkout(
            @AuthenticationPrincipal Jwt jwt) {

        String cartId = cartService.placeOrder(jwt.getSubject());
        return ResponseEntity.ok(ApiResponse.success(cartId));
    }
}
