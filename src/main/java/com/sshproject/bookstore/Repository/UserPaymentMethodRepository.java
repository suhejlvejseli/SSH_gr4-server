package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.UserPaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPaymentMethodRepository extends JpaRepository<UserPaymentMethod, Integer> {
    // You can add custom query methods here if needed
    List<UserPaymentMethod> findByUserId(int id);
}
