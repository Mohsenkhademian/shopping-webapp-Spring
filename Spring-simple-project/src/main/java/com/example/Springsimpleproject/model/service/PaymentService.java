package com.example.Springsimpleproject.model.service;

import com.example.Springsimpleproject.model.entity.Payment;
import com.example.Springsimpleproject.model.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public void delete(Long id) {
        if (!paymentRepository.existsById(id)) {
            throw new IllegalStateException("id not exist");
        }
        paymentRepository.deleteById(id);
    }

    public Payment update(Long id , Payment payment) {
        if (!paymentRepository.existsById(id)) {
            throw new IllegalStateException("id not exist");
        }
        return paymentRepository.save(payment);
    }

    public Optional<Payment> findById(Long id) {
        if (!paymentRepository.existsById(id)) {
            throw new IllegalStateException("id not exist");
        }
        return paymentRepository.findById(id);
    }
}

