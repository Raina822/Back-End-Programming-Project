package com.example.d288.services;

import com.example.d288.dao.CartItemRepository;
import com.example.d288.dao.CartRepository;
import com.example.d288.dao.CustomerRepository;
import com.example.d288.entities.Cart;
import com.example.d288.entities.CartItem;
import com.example.d288.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.UUID;
import static com.example.d288.entities.StatusType.CartStatus.ordered;


@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CartItemRepository cartItemRepository;
    private CartRepository cartRepository;
    private CustomerRepository customerRepository;


    public CheckoutServiceImpl(CartItemRepository cartItemRepository, CartRepository cartRepository, CustomerRepository customerRepository){
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;

    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder (Purchase purchase){

        Cart cart = purchase.getCart();
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);
        cart.setStatus(ordered);
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));
        cartRepository.save(cart);
        Customer customer = purchase.getCustomer();

        customer.add(cart);
        return new PurchaseResponse(orderTrackingNumber);

    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID version-4)
        return UUID.randomUUID().toString();
    }
}