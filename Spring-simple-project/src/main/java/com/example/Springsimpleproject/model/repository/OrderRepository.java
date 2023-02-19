package com.example.Springsimpleproject.model.repository;

import com.example.Springsimpleproject.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order , Long> {
}
