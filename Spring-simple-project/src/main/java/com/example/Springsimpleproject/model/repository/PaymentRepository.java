package com.example.Springsimpleproject.model.repository;

import com.example.Springsimpleproject.model.entity.Payment;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;

@ReadingConverter
public interface PaymentRepository extends JpaRepository<Payment , Long> {
}
