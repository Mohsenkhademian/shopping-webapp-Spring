package com.example.Springsimpleproject.model.service;

import com.example.Springsimpleproject.model.entity.Payment;
import com.example.Springsimpleproject.model.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @CacheEvict(value = "users", allEntries = true)
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Cacheable(value = "users")
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @CacheEvict(value = "users", allEntries = true)
    public void delete(Long id) {
        if (!paymentRepository.existsById(id)) {
            throw new IllegalStateException("id not exist");
        }
        paymentRepository.deleteById(id);
    }

    @CacheEvict(value = "users", allEntries = true)
    public Payment update(Long id , Payment payment) {
        if (!paymentRepository.existsById(id)) {
            throw new IllegalStateException("id not exist");
        }
        payment.setId(id);
        return paymentRepository.save(payment);
    }

    @Cacheable(value = "users", key = "#id")
    public Optional<Payment> findById(Long id) {
        if (!paymentRepository.existsById(id)) {
            throw new IllegalStateException("id not exist");
        }
        return paymentRepository.findById(id);
    }
}

