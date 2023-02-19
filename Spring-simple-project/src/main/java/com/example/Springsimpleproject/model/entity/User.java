package com.example.Springsimpleproject.model.entity;

import com.google.gson.Gson;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "userEntity")
@Table(name = "userTable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String email;
    private String password;

    // One-to-many relationship with Order entity
    @OneToMany(mappedBy = "user")
    private Set<Order> orders = new HashSet<>();

    // One-to-many relationship with Payment entity
    @OneToMany(mappedBy = "user")
    private Set<Payment> payments = new HashSet<>();

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
