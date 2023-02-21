package com.example.Springsimpleproject.model.service;

import com.example.Springsimpleproject.model.entity.Order;
import com.example.Springsimpleproject.model.entity.User;
import com.example.Springsimpleproject.model.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    @CacheEvict(value = "users", allEntries = true)
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    @Cacheable(value = "users")
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Transactional
    @CacheEvict(value = "users", allEntries = true)
    public void delete (Long id) {
        if (!orderRepository.existsById(id)){
            throw new IllegalStateException("id not exist");
        }
        orderRepository.deleteById(id);
    }

    @Transactional
    @CacheEvict(value = "users", allEntries = true)
    public Order update(Long id , Order order) {
        if (!orderRepository.existsById(id)) {
            throw new IllegalStateException("id not exist");
        }
        order.setId(id);
        return orderRepository.save(order);
    }

    @Transactional
    @Cacheable(value = "users", key = "#id")
    public Optional<Order> findById(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new IllegalStateException("id not exist");
        }
        return orderRepository.findById(id);
    }
}
