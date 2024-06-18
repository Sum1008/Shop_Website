package com.grocery.shop.grocery.service;

import java.util.List;

import com.grocery.shop.grocery.entity.Cart;
import com.grocery.shop.grocery.entity.Customer;


public interface CartService {

	void saveCartItems(List<Cart> cartsItems);
	void saveCart(Cart cart);
	List<Cart> getCartItemsByCustomerId(Customer customer);
	void removeCartItems(Customer customer, Long id);
	void removeCartItem(Long id);
}