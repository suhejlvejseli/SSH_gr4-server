package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer>{

    List<Cart> findByCartId(int cartId);
}
