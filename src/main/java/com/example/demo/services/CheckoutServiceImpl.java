package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.dto.Purchase;
import com.example.demo.dto.PurchaseResponse;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;


    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the order info from dto

        Cart cart = purchase.getCart();

        //generate tracking number

        String cartTrackingNumber = generateCartTrackingNumber();
        cart.setOrderTrackingNumber(cartTrackingNumber);

        // populate order with cartItems

        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));

        cart.setCartItem(purchase.getCartItems());
        cart.setCustomer(purchase.getCustomer());

        //populate with customer order

        Customer customer = purchase.getCustomer();
        customer.add(cart);

        //save to the database

        //customerRepository.save(customer);
        cartRepository.save(cart);

        cart.setStatus(Cart.StatusType.ordered);


        //return a response
        return new PurchaseResponse(cartTrackingNumber);


    }

    private String generateCartTrackingNumber() {

        // generate a random UUID number

        return UUID.randomUUID().toString();


    }

}
