package com.example.d288.dao;

import com.example.d288.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "cart_items", path = "cart_items")
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}