package com.vitor.shoppingcart.controller;

import com.vitor.shoppingcart.model.Cart;
import com.vitor.shoppingcart.model.Item;
import com.vitor.shoppingcart.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CartController {

    private CartService cartService;

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cart addItem(@PathVariable Long id, @RequestBody Item item) {
        return cartService.addItem(id, item);
    }

    @GetMapping("/{id}")
    public Cart findById(@PathVariable Long id) throws Exception {
        return cartService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void clearCart(@PathVariable Long id) {
        cartService.clear(id);
    }

}
