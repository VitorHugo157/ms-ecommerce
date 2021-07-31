package com.vitor.shoppingcart.service;

import com.vitor.shoppingcart.model.Cart;
import com.vitor.shoppingcart.model.Item;
import com.vitor.shoppingcart.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CartService {

    private CartRepository cartRepository;

    public Cart addItem(Long id, Item item) {
        Optional<Cart> savedCart = cartRepository.findById(id);
        Cart cart;
        if (savedCart.isEmpty()) {
            cart = new Cart();
        } else {
            cart = savedCart.get();
        }
        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    public Cart findById(Long id) throws Exception {
        return cartRepository.findById(id).orElseThrow(Exception::new);
    }

    public void clear(Long id) {
        cartRepository.deleteById(id);
    }

}
