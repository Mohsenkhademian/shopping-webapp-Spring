package com.example.Springsimpleproject.model.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "paymentEntity")
@Table(name = "paymentTable")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long amount;

    // Many-to-one relationship with User entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // One-to-one relationship with Order entity
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
